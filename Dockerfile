FROM openjdk:8

COPY ./target/semWorldDatabase.jar /tmp

WORKDIR /tmp

ENTRYPOINT ["java", "-jar", "semWorldDatabase.jar", "db:3306"]