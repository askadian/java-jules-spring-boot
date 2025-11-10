# Stage 1: Build the application using Maven
FROM maven:3.9.6-amazoncorretto-21-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests && \
    rm -rf /root/.m2 && \
    find target -type d -name "surefire-reports" -exec rm -rf {} +

# Stage 2: Create the final, production-ready image
FROM amazoncorretto:21
WORKDIR /app
COPY --from=builder /app/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
