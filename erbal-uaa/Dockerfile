FROM java:8-jre
MAINTAINER Matteo Bogo

ADD ./target/auth-com.erbal.service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-com.erbal.service.jar"]

EXPOSE 9090