# Stage 1: Build
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

COPY pom.xml ./
COPY .mvn/ .mvn/
COPY mvnw ./

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/monument-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
