FROM openjdk:17-jdk-apline
EXPOSE 8089
ADD target/achat-1.0.1.jar achat-1.0.1.jar
ENTRYPOINT ["java","-jar","achat-1.0.1.jar"]