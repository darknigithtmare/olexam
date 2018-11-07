FROM openjdk:8
COPY ./target/classes/me/exam /tmp
WORKDIR /tmp
ENTRYPOINT ["java","MainApplicationClass"]