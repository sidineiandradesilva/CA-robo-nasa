@echo off
echo Efetuando o Build do Projeto...
timeout /t 1
mvnw.cmd clean install
timeout /t 5
echo Start do Projeto... 
java -jar target/robo-CA-2023.jar