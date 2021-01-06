FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

# ADD jar files from host
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs/testng-7.3.0.jar testng-7.3.0.jar
ADD target/libs libs

# In case of any other test data dependency files like .csv / .json / .xls
# please add that as well

# ADD suite files
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml

# ADD health check script
ADD healthcheck.sh healthcheck.sh

#VARIABLES to be passed 
#BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT sh healthcheck.sh