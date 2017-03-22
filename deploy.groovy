scp /var/lib/jenkins/workspace/Python/deploy/hello.py user@172.31.106.83 address:/var/www/demoapp
ssh -i /var/lib/jenkins/.ssh/id_rsa user@172.31.106.83 address 'sudo service uwsgi restart'
