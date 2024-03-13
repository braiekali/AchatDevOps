FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/achat-1.0.1.jar achat-1.0.1.jar
ENTRYPOINT ["java","-jar","achat-1.0.1.jar"]