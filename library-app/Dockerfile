# Stage 1: Build the application using Maven
FROM maven:3.9.6-amazoncorretto-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package && rm -rf target/surefire-reports && rm -rf target/maven-archiver && rm -rf target/classes

# Stage 2: Create the final, production-ready image
FROM amazoncorretto:21
WORKDIR /app
COPY --from=builder /app/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
