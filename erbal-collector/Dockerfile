FROM java:8-jre
MAINTAINER Matteo Bogo

ADD ./target/erbal-collector.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/erbal-collector.jar"]

EXPOSE 9001