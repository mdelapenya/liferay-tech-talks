#!/bin/bash

# stop the instance
ec2-stop-instances $1

# detach EBS
ec2-detach-volume vol-XXXXXX

#
ec2-create-image i-8eda73e4 -n app-server-20100728 -d 'Liferay Application Server'

# create an image for this instance, with the given name and description
$ ec2-create-image i-8eda73e4 -n app-server-20100728 -d 'Rails Application Server'

# start the instance (again), attach the volume and associate elastic ip

ec2-start-instances i-8eda73e4
ec2-attach-volume vol-c00177a9 -i i-8eda73e4 -d /dev/sdf
ec2-associate-address 184.72.235.156 -i i-8eda73e4
