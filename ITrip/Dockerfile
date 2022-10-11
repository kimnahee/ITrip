FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY Wallet_ITrip /home/wallet_itrip
ENTRYPOINT ["java","-jar", "/app.jar"]