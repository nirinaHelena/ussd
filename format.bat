@echo off

REM
for /R %%i IN (*.java) DO (
    java -jar config\google-java-format-1.23.0-all-deps.jar --replace %%i
)

REM
java -jar config\checkstyle-10.12.3-all.jar -c /google_checks.xml -r src
