#!/bin/bash

## Script usage: AWSRunningInstances <image id><num of instances><machine type>


# add the keypair

ec2-add-keypair migue

# create the security group

ec2-add-group liferay -d 'All public facing web (port 80 and 443) instances'
ec2-authorize liferay -P tcp -p 22  -s 0.0.0.0/0
ec2-authorize liferay -P tcp -p 80  -s 0.0.0.0/0
ec2-authorize liferay -P tcp -p 443 -s 0.0.0.0/0

# launch n (passed as the second argument to the script) instances of the image passed as the first argument to the script

ec2-run-instances $1 --instance-count $2 --instance-type $3 --key migue --group liferay

# stop the instance explicitly, and detach the volume
$ ec2-stop-instances i-8eda73e4
Creating the Rails Server on EC2 | 31
$ ec2-detach-volume vol-c00177a9
# create an image for this instance, with the given name and description
$ ec2-create-image i-8eda73e4 -n app-server-20100728 -d 'Rails Application Server'

# start the instance again, attach the volume and associate elastic ip
ec2-start-instances i-8eda73e4
ec2-attach-volume vol-c00177a9 -i i-8eda73e4 -d /dev/sdf
ec2-associate-address 184.72.235.156 -i i-8eda73e4
