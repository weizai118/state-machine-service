FROM registry.cn-hangzhou.aliyuncs.com/choerodon-tools/javabase:0.7.0
COPY app.jar /state-machine-service.jar
ENTRYPOINT exec java $JAVA_OPTS  -jar /state-machine-service.jar
