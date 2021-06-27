FROM openjdk:12
ADD target/docker-gateway-service.jar docker-gateway-service.jar
EXPOSE 8989
ENTRYPOINT ["java","-jar","docker-gateway-service.jar"]