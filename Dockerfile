FROM openjdk:8-jdk-apline
EXPOSE 8089
ADD target/achat-1.0.2.jar achat-1.0.2.jar
ENTRYPOINT ["java","-jar","achat-1.0.2.jar"]