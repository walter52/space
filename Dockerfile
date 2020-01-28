FROM maven:3.6.0-jdk-8-alpine AS builder
ADD ./pom.xml pom.xml
ADD ./conf/settings.xml /usr/share/maven/ref/
ADD ./space-console/src space-console/src/
ADD ./space-console/pom.xml space-console/pom.xml
#RUN mvn -B  -s /usr/share/maven/ref/settings.xml dependency:resolve && mvn clean package -Dmaven.test.skip=true
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:8-jre-alpine
COPY --from=builder space-console/target/*.jar ROOT.jar
CMD ["java", "-jar", "ROOT.jar"]
