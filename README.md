# Java Spring Boot Essentials

This repository contains the implementation of various structures and concepts to build a Rest API using Java Spring Boot.

## Architecture
This project is divided into the following modules:
- **core**: Contains the core functionalities of the application, holding the business logic.
- **application**: Contains the application layer, responsible for handling the requests and responses.
- **infrastructure**: Contains the infrastructure layer, responsible for handling the database and external services.
- **java-spring-boot-essentials**: Contains the main class and some configurations of the application.

This was done to separate the concerns and make the project more organized and maintainable, following the principles of the ``Clean Architecture`` and some ``Hexagonal Architecture`` concepts.

All dependencies are managed by parent `pom.xml` file.

## Some Technologies
- Docker (for running the database and the application)
- MapStruct (for mapping objects)
- Flyway (for database migrations)
- DBRider (for testing the database)
