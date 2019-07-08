
FROM maven:3.6.0-jdk-8-slim AS Builder
LABEL key="https://finalexception.blogspot.com"
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /app/pom.xml
COPY src /app/src
WORKDIR /app
RUN mvn clean package

FROM jboss/wildfly
EXPOSE 8080
WORKDIR /opt/jboss/wildfly/standalone/deployments/
COPY --from=Builder /app/target/front-end.war .