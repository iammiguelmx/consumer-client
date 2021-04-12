FROM maven:3.8.1-jdk-8 AS build
COPY src /home/consumer/src
COPY pom.xml /home/consumer
RUN mvn -f /home/consumer/pom.xml clean package

FROM openjdk:11
# WORKDIR /home
COPY --from=build /home/consumer/target/demo-consumer-0.0.1-SNAPSHOT.jar /usr/src/app/demo-consumer-0.0.1-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/usr/src/app/demo-consumer-0.0.1-SNAPSHOT.jar"]
