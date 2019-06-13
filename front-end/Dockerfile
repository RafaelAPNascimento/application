
FROM openjdk:8 AS Builder
MAINTAINER "https://finalexception.blogspot.com"
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /app/pom.xml
COPY src /app/src
WORKDIR /app
RUN mvn clean install

FROM jboss/wildfly
EXPOSE 8080
WORKDIR /opt/jboss/wildfly/standalone/deployments/
COPY --from=Builder /app/target/front-end.war .