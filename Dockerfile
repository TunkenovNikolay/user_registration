FROM maven:3.8.1-jdk-11 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:resolve

COPY src src
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app

COPY --from=builder /app/target/usersbase-0.0.1-SNAPSHOT.jar /app
CMD exec java -jar usersbase-0.0.1-SNAPSHOT.jar