# 基础镜像，openjkd使用8版本
FROM openjdk:8
# 作者
MAINTAINER guozhe guozhegz@gmail.com
# 系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
RUN mkdir -p /usr/src/app
COPY target/client-api-1.0.jar /usr/src/app
WORKDIR /usr/src/app
EXPOSE 9000 9000
CMD ["java", "-jar", "client-api-1.0.jar"]
