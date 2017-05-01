FROM java:8-jre
MAINTAINER Matteo Bogo

ADD ./target/erbal-gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/erbal-gateway.jar"]

EXPOSE 9999