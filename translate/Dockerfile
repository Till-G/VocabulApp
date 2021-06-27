FROM openjdk:12
ADD target/docker-translate-service.jar docker-translate-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","docker-translate-service.jar"]