FROM maven:3.6.0-jdk-8-alpine AS builder
COPY ./pom.xml /build/
COPY ./settings.xml /usr/share/maven/ref/
COPY ./space-console/src /build/space-console/src/
COPY ./space-console/pom.xml /build/space-console/
RUN mvn -B -f /build/pom.xml  && mvn clean package -Dmaven.test.skip=true

FROM openjdk:8-jre-alpine
COPY --from=builder space-console/target/*.jar ROOT.jar
CMD ["java", "-jar", "ROOT.jar"]
