elb-create-lb production \
		--availability-zones us-east-1b \
		--listener "protocol=HTTP, lb-port=80, instance-port=80" \
		--listener "protocol=TCP, lb-port=443, instance-port=443"
		
elb-configure-healthcheck production \
		--target "HTTP:80/" \
		--interval 30 \
		--timeout 2 \
		--healthy-threshold 6 \
		--unhealthy-threshold 2

elb-register-instances-with-lb production \
		--instances i-29184c43
