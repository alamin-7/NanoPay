# Stage 1 - Build
FROM eclipse-temurin:17-jdk AS builder

WORKDIR /app
COPY . .

RUN ./gradlew clean build -x test

# Stage 2 - Runtime
FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
