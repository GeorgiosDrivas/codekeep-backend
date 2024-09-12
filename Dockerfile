# Step 1: Build the JAR file
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy the source code into the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Step 2: Create the actual container
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copy the JAR file from the build stage to the app directory
COPY --from=build /app/target/snippets-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
