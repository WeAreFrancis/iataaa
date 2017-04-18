FROM java:8-jre
MAINTAINER Anthony Godin <gdn.anthony@gmail.com>

ADD ./target/aiPlayer-service-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/aiPlayer-service-1.0-SNAPSHOT.jar"]

EXPOSE 6000