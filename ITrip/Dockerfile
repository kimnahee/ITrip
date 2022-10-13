FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY wallet_itrip/* /wallet_itrip/
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]
