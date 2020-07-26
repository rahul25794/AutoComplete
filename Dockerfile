FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar","--spring.datasource.url=jdbc:mysql://host.docker.internal:3306/test"]