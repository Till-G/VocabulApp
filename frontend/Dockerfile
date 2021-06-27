FROM openjdk:12
ADD target/docker-frontend-service.jar docker-frontend-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-frontend-service.jar"]