FROM openjdk:11
WORKDIR /home
COPY ./target/**.jar /usr/src/app/consumer.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/consumer.jar"]
