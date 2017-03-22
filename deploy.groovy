scp -i /home/user/.ssh/id_rsa /var/lib/jenkins/workspace/Python/deploy/hello.py user@172.31.106.83:/var/www/demoapp
ssh -i /home/user/.ssh/id_rsa user@172.31.106.83 'sudo service uwsgi restart'
