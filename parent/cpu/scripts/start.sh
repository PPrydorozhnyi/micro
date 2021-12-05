#!/usr/bin/env bash
set -e

#env
echo "==> Start central with active profile=$SPRING_PROFILE"

java -jar  ${JAVA_ARGS} "-Dspring.profiles.active=$SPRING_PROFILE"   "/usr/share/micro/cpu.jar"
