FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/achat-1.0.1.jar nawressachat:1.0.1
ENTRYPOINT ["java","-jar","nawressachat:1.0.1"]