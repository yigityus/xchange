FROM amazoncorretto:21.0.4-alpine3.18
ARG JAR_FILE=target/"xchange-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} "xchange-0.0.1-SNAPSHOT.jar"
ENTRYPOINT ["java", "-jar", "/xchange-0.0.1-SNAPSHOT.jar"]
