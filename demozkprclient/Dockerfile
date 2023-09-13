FROM gradle:8.2.1-alpine

MAINTAINER Osman Can Iskit, <caniskit@gmail.com>

ENV APP_DIR=/spring-boot-app

EXPOSE 8082

RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh

# App configuration
WORKDIR ${APP_DIR}
RUN mkdir -p ${APP_DIR}
# RUN git clone

COPY * ${APP_DIR}/
COPY src ${APP_DIR}/src

RUN gradle build

ENTRYPOINT ["java"]
CMD ["-jar", "build/libs/demozkprclient-0.0.1-SNAPSHOT.jar"]
