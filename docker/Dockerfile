FROM openjdk:11.0-jdk-slim-stretch

COPY "appgate-calculadora-rest.jar" "app.jar"

RUN apt-get install -y tzdata

ENV TZ America/Bogota

VOLUME ["/home"]

ENTRYPOINT ["java", "-jar","app.jar"]