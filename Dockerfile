FROM eclipse-temurin:11-alpine

WORKDIR /app

COPY target/*.jar /app/api.jar

EXPOSE 8081

CMD ["java", "-jar", "api.jar"]