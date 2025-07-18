# Usa la imagen oficial de Maven para construir el proyecto
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Usa una imagen ligera de Java para correr la app
FROM eclipse-temurin:17-jdk-alpine
COPY --from=builder /app/target/notas-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
