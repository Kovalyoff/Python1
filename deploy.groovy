scp /var/lib/jenkins/jobs/Project/build/hello.py user@172.31.106.83_172.31.20.212 address:/var/www/demoapp
ssh -i /var/lib/jenkins/.ssh/id_rsa user@172.31.106.83_172.31.20.212 address 'sudo service uwsgi restart'
