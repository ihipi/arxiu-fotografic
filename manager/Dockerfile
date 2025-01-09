FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
LABEL authors="AGIROQU"
COPY --from=build /app/target/manager-*.jar /app/manager.jar
ENTRYPOINT ["java", "-jar", "/app/manager.jar"]