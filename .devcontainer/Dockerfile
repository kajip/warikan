# BIGLOBE Java DDD

FROM centos:7

COPY adoptopenjdk.repo /etc/yum.repos.d/

ENV JAVA_HOME=/usr/lib/jvm/adoptopenjdk-8-hotspot
ENV LANG=ja_JP.UTF-8

RUN yum install -y ibus-kkc vlgothic-* &&\
    yum install -y adoptopenjdk-8-hotspot git &&\
    yum install -y graphviz
