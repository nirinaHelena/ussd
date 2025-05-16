#!/bin/sh

find src -name "*.java" -exec java -jar config/google-java-format-1.23.0-all-deps.jar --replace {} \;

java -jar config/checkstyle-10.12.3-all.jar -c /google_checks.xml src