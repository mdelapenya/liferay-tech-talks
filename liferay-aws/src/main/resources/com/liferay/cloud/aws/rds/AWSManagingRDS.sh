rds-create-db-security-group liferay-production --db-security-group-description 'Secure the ports'

rds-authorize-db-security-group-ingress liferay-production --cidr-ip 0.0.0.0/0

rds-authorize-db-security-group-ingress production --ec2-security-group-name web --ec2-security-group-owner-id XXXXX

rds-create-db-instance production 	--engine MySQL5.1 \
									--db-instance-class db.m1.small \
									--allocated-storage 5 \
									--master-username lportal \
									--master-user-password lportal \
									--db-security-groups liferay-production \
									--backup-retention-period 3
