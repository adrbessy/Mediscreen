<img src="https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white"/> * * *  <img src="https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white"/>  * * *  <img src="https://img.shields.io/badge/docker%20-%230db7ed.svg?&style=for-the-badge&logo=docker&logoColor=white"/>

# Mediscreen
An application to predict risks of diseases.
This app uses Java to run.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

What things you need to install the software and how to install them

- Java 1.8
- Maven 4.0.0

### Installing

A step by step series of examples that tell you how to get a development env running:

1.Install Java:

https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

2.Install Maven:

https://maven.apache.org/install.html

### Running App

You can run the application in two different ways:

1/ import the code into an IDE of your choice and run the Application.java to launch the application.

2/ Or import the code, unzip it, open the console, go to the folder that contains the pom.xml file, then execute the below command to launch the application.

```bash
mvn spring-boot:run 
```

### Docker deploiement

Generate a jar file for each java microservice with:

```bash
mvn package
```


Then go to the folder that contains the Dockerfile, and then to build an image type:

```bash
docker build -t mediscreen-patient:0.0.1 .
```

Then go to the respective folder of each microservice and to build the images type:

```bash
docker build -t mediscreen-angular-ui:0.0.1 .
```

Build the image of postgres:

```bash
docker build -t postgres:latest
```


Then to deploy all mediscreen microservices, type :

```bash
docker-compose up -d
```


### API calls (URI, parameters)
GET

http://localhost:9010/patients

http://localhost:9010/patient

http://localhost:9010/patient/4

http://localhost:9010/patient?id=12


### Testing
The app has unit tests written.

To run the tests from maven, go to the folder that contains the pom.xml file and execute the below command.

```bash
mvn test
```

