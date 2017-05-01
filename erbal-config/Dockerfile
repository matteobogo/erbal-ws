FROM java:8-jre
MAINTAINER Matteo Bogo

ADD ./erbal-config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/erbal-config.jar"]

EXPOSE 8888