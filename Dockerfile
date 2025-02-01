FROM maven:3.8.5-opendk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build target/pastebin-0.0.1-SNAPSHOT.jar pastebin.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","pastebin.jar"]