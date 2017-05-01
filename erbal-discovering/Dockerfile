FROM java:8-jre
MAINTAINER Matteo Bogo

ADD ./target/erbal-discovering.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/erbal-discovering.jar"]

EXPOSE 8761