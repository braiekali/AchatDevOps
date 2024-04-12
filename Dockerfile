FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/achat.jar achat.jar

ENTRYPOINT ["java","-jar","sarrakach/achat.jar"]