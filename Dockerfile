FROM clojure:lein-2.8.1 AS build
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN lein ring uberjar

FROM openjdk:8u181-jre-slim
COPY --from=build /usr/src/app/target/url-shortener-0.1.0-SNAPSHOT-standalone.jar .
CMD ["java", "-jar", "url-shortener-0.1.0-SNAPSHOT-standalone.jar"]