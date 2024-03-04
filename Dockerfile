#
# Build stage
#
FROM maven:3.9.1 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/*.jar app.jar
# ENV PORT=8080
EXPOSE 3000
ENTRYPOINT ["java","-jar","app.jar"]