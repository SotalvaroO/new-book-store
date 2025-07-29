FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .
RUN rm -rf target
RUN mvn clean package

FROM openjdk:17
COPY --from=build /app/target/*.jar /opt/app/app.jar
WORKDIR /opt/app

CMD ["sh", "-c", "java -jar ./app.jar"]
