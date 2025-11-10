# Use an official Amazon Corretto runtime as a parent image
#FROM amazoncorretto:11-alpine-jdk

# Set the working directory in the container
#WORKDIR /app

# Copy the executable JAR file from the host to the container
#COPY library-app/target/library-app-1.0-SNAPSHOT.jar app.jar

# Expose the port the app runs on
#EXPOSE 8080

# Command to run the application
#ENTRYPOINT ["java","-jar","app.jar"]
FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
