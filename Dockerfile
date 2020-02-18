FROM openjdk:8

COPY ./target/semWorldDatabase-0.1.0.4-jar-with-dependencies.jar /tmp

WORKDIR /tmp

ENTRYPOINT ["java", "-jar", "semWorldDatabase-0.1.0.4-jar-with-dependencies.jar"]