FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY build/libs/spring-cloud-demos.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]