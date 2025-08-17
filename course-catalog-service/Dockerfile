FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY build/libs/course-catalog-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]