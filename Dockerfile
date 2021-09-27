FROM openjdk:11-jdk-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} converter.jar
ENTRYPOINT ["java","-jar","/converter.jar"]