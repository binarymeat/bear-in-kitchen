FROM java:8-jre

ADD ./target/gateway-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway-service.jar"]

EXPOSE 4000