#! /bin/bash

chmod -R 777 /usr/local/nursinghomesystem

cd /usr/local/nursinghomesystem

killall -9 java
mvn clean package  -Dmaven.test.skip=true
nohup java -jar  target/NursingHomeSystem-1.0.0.jar &




