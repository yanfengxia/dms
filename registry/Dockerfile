FROM openjdk:8-slim
MAINTAINER xiayanfeng
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]