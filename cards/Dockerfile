FROM openjdk:12
ADD target/docker-card-service.jar docker-card-service.jar
EXPOSE 8093
ENTRYPOINT ["java", "-jar", "docker-card-service.jar"]