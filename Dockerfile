FROM maven:3.8.1-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11
# WORKDIR /home
COPY --from=build /home/app/target/demo-consumer-0.0.1-SNAPSHOT.jar /usr/src/app/demo-consumer-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/demo-consumer-0.0.1-SNAPSHOT.jar"]
