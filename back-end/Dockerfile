# production Dockerfile
FROM openjdk:8 AS Builder
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /app/pom.xml
COPY src /app/src
WORKDIR /app
RUN mvn clean install


FROM openjdk:8
WORKDIR /deployed-app
COPY --from=Builder /app/target/back-end.jar .
#ADD target/back-end.jar .
ENTRYPOINT ["java", "-jar", "back-end.jar"]    
