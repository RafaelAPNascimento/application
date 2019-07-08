# production Dockerfile
#FROM maven:3.6.0-jdk-8-slim AS Builder
#COPY pom.xml /app/pom.xml
#COPY src /app/src
#WORKDIR /app
#RUN mvn clean package


#FROM openjdk:8-jre-alpine
#WORKDIR /deployed-app
#COPY --from=Builder /app/target/back-end.jar .
#ENTRYPOINT ["java", "-jar", "back-end.jar"]    

#FROM openjdk:8-jre
#WORKDIR /app
#VOLUME ["/app"]
#COPY maven/app.jar app.jar
#COPY maven/start.sh start.sh
#COPY maven/wait-for-it.sh wait-for-it.sh
#RUN sh -c 'touch back-end.jar'
#ENTRYPOINT ["./start.sh"]

FROM openjdk:8-jre
WORKDIR /app
VOLUME ["/app"]
COPY maven/back-end.jar back-end.jar
COPY maven/start.sh start.sh
COPY maven/wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch back-end.jar'
ENTRYPOINT ["./start.sh"]

