FROM openjdk:8
COPY ./target /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "excersice-1.0-SNAPSHOT.jar"]