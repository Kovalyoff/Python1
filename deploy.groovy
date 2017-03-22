scp /var/lib/jenkins/jobs/Project/build/hello.py user@172.31.106.83 address:/var/www/demoapp
ssh -i /var/lib/jenkins/.ssh/id_rsa user@172.31.106.83 address 'sudo service uwsgi restart'
