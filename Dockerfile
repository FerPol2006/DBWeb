FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace/db
COPY db/pom.xml ./pom.xml
COPY db/src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
ENV PORT=8080
COPY --from=build /workspace/db/target/*.jar app.jar
EXPOSE 8080
CMD ["sh", "-c", "java -Dserver.port=${PORT} -jar /app/app.jar"]

