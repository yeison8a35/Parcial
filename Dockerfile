FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/notas-api.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]