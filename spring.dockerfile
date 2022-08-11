FROM maven:3.8.6-jdk-11 as jar-builder
WORKDIR /harry
COPY . .
RUN mvn package -DskipTests

FROM openjdk:11-jdk-oracle
WORKDIR /harry-pointer
COPY --from=jar-builder /harry/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]