FROM java:8-jre
MAINTAINER Anthony Godin <gdn.anthony@gmail.com>

ADD ./target/config-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-1.0-SNAPSHOT.jar"]

EXPOSE 8888