@echo off
cd wildfly-29.0.1.Final\bin\
start cmd /k standalone.bat  
timeout /t 15 /nobreak
start http://127.0.0.1:8080/departments-1.0-SNAPSHOT/index.jsf