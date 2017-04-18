FROM java:8-jre
MAINTAINER Anthony Godin <gdn.anthony@gmail.com>

ADD ./target/registry-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry-1.0-SNAPSHOT.jar"]

EXPOSE 8761