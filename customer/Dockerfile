FROM maven:3.6.3-jdk-8-slim as builder
ENTRYPOINT []
ARG MVN_ARGS
ADD ./src/ /app/src/
ADD ./pom.xml /app/pom.xml
WORKDIR /app
RUN echo "127.0.0.1 customer-postgres" >> /etc/hosts && mvn --batch-mode package -DskipTests=true

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8103
ENTRYPOINT ["java","-jar","app.jar"]
