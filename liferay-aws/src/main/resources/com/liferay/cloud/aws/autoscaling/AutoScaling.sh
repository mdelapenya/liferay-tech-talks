as-create-auto-scaling-group app-server-as-group-1 \
	--launch-configuration app-server-launch-config-1 \
	--availability-zones us-east-1c,us-east-1d \
	--min-size 2 \
	--max-size 6 \
	--default-cooldown 120 \
	--load-balancers production


# Políticas de escalado
as-put-scaling-policy app-server-scale-UP-on-CPU \
--auto-scaling-group app-server-as-group-1 \
--type ChangeInCapacity \
--adjustment 2 \
--cooldown 300
$ mon-put-metric-alarm alarm-app-server-scale-UP \
--alarm-actions arn:aws:autoscaling:us-east-1:205414005158:scalingPolicy:...
--metric-name CPUUtilization \
--unit Percent \
--namespace AWS/EC2 \
--statistic Average \

