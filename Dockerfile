FROM openjdk:17-oracle
COPY infrastructure/target/*.jar /app.jar
ENV SERVER_PORT 8080
EXPOSE ${SERVER_PORT}
EXPOSE 8081
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
