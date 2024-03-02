FROM openjdk:11-jre-slim

VOLUME /tmp

VOLUME /tmp

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

