FROM java:8-jre
MAINTAINER Anthony Godin <gdn.anthony@gmail.com>

ADD ./target/gateway-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway-1.0-SNAPSHOT.jar"]

EXPOSE 4000