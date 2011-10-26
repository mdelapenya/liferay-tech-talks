MAX_TRIES=60
prog=$(basename $0)

logger="logger -t $prog"
curl="curl --retry 3 --silent --show-error --fail"

# Info about the current instance
instance_data_url=http://current_instance_url/latest
region="eu-west-1"
elastic_ip=184.72.235.156
vol="vol-c00177a9"
dev="/dev/sdf"
mnt="/opt/liferay"

# Need to wait until networking is up on the EC2 instance.
perl -MIO::Socket::INET -e ' until(new IO::Socket::INET("169.254.169.254:80"))

{print "Waiting for network...\n";sleep 1}' | $logger


# start/stop functions for the underlying OS
start() {
ctr=0
# because the instance might change we have to get the id dynamically
instance_id=$($curl $instance_data_url/meta-data/instance-id)
/bin/echo "Associating Elastic IP."
ec2-associate-address $elastic_ip -i $instance_id --region=$region
/bin/echo "Attaching Elastic Block Store Volumes."
ec2-attach-volume $vol -i $instance_id -d $dev --region=$region
/bin/echo "Testing If Volumes are Attached."
while [ ! -e "$dev" ] ; do
/bin/sleep 1
ctr=`expr $ctr + 1`
# retry for maximum one minute...
if [ $ctr -eq $MAX_TRIES ]; then
Creating the Rails Server on EC2 | 33
fi
if [ ! -e "$dev" ]; then
/bin/echo "WARNING: Cannot attach volume $vol to $dev --
Giving up after $MAX_TRIES attempts"
fi
done
if [ -e "$dev" ]; then
if [ ! -d $mnt ]; then
mkdir $mnt
fi
/bin/echo "Mounting Elastic Block Store Volumes."
/bin/mount -t xfs -o defaults $dev $mnt
fi
}
stop() {
/bin/echo "Disassociating Elastic IP."
ec2-disassociate-address $elastic_ip --region=$region
/bin/echo "Unmounting Elastic Block Store Volumes."
/bin/umount $mnt
ec2-detach-volume $vol --region=$region
}
case "$1" in
start)
start
;;
stop)
stop
;;
restart)
stop
sleep 5
start
;;
*)
echo "Usage: $SELF {start|stop|restart}"
exit 1
;;
esac
exit 0
