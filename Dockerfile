FROM openjdk:17

COPY target/leetcode-api-0.0.1-SNAPSHOT.jar /app/leet-fetcher.jar

EXPOSE 8080

WORKDIR /app

CMD ["java", "-jar", "leet-fetcher.jar"]