#!/usr/bin/env bash
# Environments Variables
# HUB_HOST
# BROWSER
# MODULE

echo "Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://"$HUB_HOST":4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/testng-7.3.0:libs/* -DHUB_HOST="$HUB_HOST" -DBROWSER="$BROWSER" org.testng.TestNG "$MODULE"