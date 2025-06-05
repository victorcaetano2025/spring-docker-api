FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY database ./database   
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/database ./database 
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
