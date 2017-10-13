FROM java:8-jre

ADD ./target/auth-service.jar /app/
CMD ["java", "-Xmx200m", "-agentlib:jdwp=transport=dt_socket,address=8001,server=y,suspend=n", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/auth-service.jar"]

EXPOSE 5000