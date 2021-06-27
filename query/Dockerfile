FROM openjdk:12
ADD target/docker-query-service.jar docker-query-service.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","docker-query-service.jar"]