#start with a base image
FROM openjdk:17-jdk-slim

#who maintains the image
MAINTAINER harish

#add the application jar to the image
COPY target/plans-module-0.0.1-SNAPSHOT.jar plans-module-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","plans-module-0.0.1-SNAPSHOT.jar"]