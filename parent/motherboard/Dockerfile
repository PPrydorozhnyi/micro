FROM openjdk:17-slim

MAINTAINER Petro

COPY ./scripts/start.sh /

ARG JAR_FILE
COPY "target/${JAR_FILE}" "/usr/share/micro/${JAR_FILE}"

ENTRYPOINT ["/start.sh"]
