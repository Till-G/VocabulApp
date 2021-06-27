FROM openjdk:12
ADD target/docker-registry-service.jar docker-registry-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","docker-registry-service.jar"]