FROM java:8-jre
MAINTAINER Matteo Bogo

ADD ./target/auth-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-service.jar"]

EXPOSE 9090