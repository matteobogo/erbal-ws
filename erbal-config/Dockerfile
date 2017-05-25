FROM frolvlad/alpine-oraclejdk8
MAINTAINER Matteo Bogo
ADD target/erbal-config.jar erbal-config.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/erbal-config.jar"]