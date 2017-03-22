scp /var/lib/jenkins/jobs/Project/build/hello.py user@ip address:/var/www/demoapp
ssh -i /var/lib/jenkins/.ssh/id_rsa user@ip address 'sudo service uwsgi restart'