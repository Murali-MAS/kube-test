FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} license-app.jar
ENTRYPOINT ["java","-jar","/license-app.jar"]