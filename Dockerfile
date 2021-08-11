FROM openjdk:8
ADD target/mediscreen-patient-0.0.1-SNAPSHOT.jar mediscreen-patient-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/mediscreen-patient-0.0.1-SNAPSHOT.jar"]
