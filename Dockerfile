FROM openjdk:11
COPY demo/target/demo-0.0.1-SNAPSHOT.jar /usr/src/devopsdemo.jar
WORKDIR /usr/src
CMD ["java","-jar","devopsdemo.jar"]