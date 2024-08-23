# Java Modular Architecture with Spring Boot

This repository contains the implementation of various structures and concepts to build a Rest API
using Java Spring Boot.

## Architecture

This project is divided into the following modules:

- **core**: Contains the core functionalities of the application, holding the business logic.
- **application**: Contains the application layer, responsible for handling the requests and
  responses.
- **infrastructure**: Contains the infrastructure layer, responsible for handling the database and
  external services.
- **java-spring-boot-essentials**: Contains the main class and some configurations of the
  application.

This was done to separate the concerns and make the project more organized and maintainable,
following the principles of the ``Clean Architecture`` and some ``Hexagonal Architecture`` concepts.

All dependencies are managed by parent `pom.xml` file.

## Some Technologies

| Language                                                                                                                                  | Description                              |
|-------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------|
| <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" width="80" />             | main language                            |
| <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker" width="80" />          | running the database and the application |
| <img src="https://img.shields.io/badge/MapStruct-007CAB?style=for-the-badge&logo=mapstruct&logoColor=white" alt="MapStruct" width="80" /> | mapping objects                          |
| <img src="https://img.shields.io/badge/Flyway-525252?style=for-the-badge&logo=flyway&logoColor=white" alt="Flyway" width="80" />          | database migrations                      |
| <img src="https://img.shields.io/badge/DBRider-525252?style=for-the-badge&logo=java&logoColor=white" alt="DBRider" width="80" />          | testing the database                     |
