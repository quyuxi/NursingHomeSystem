#! /bin/bahs

mkdir /usr/local/NursingHomeSystem
chmod -R 777 /usr/local/NursingHomeSystem
cp  ./NursingHomeSystem*.jar  /usr/local/NursingHomeSystem/app.jar
sudo ln -s /home/app.jar /etc/init.d/app
service app start
