# Workout Manager

A Spring Boot application for managing client workouts, providing both REST API and GraphQL endpoints.

## Project Overview

Workout Manager is a comprehensive solution for tracking and managing client workout schedules. It allows you to record different types of workouts (weight training and cardio) for clients on specific dates and retrieve workout histories.

## Technologies Used

- Java 21
- Spring Boot 3.3.5
- Spring Data JPA
- PostgreSQL
- Flyway for database migrations
- GraphQL
- Lombok
- Swagger/OpenAPI for API documentation

## Project Structure

```
workoutmanager/
├── Service/
│   └── ClientService.java       # Service layer for client operations
├── WorkoutManagerApplication.java  # Main application class
├── data/
│   ├── Utility/
│   │   └── DateAndWorkout.java  # Utility class for date and workout data
│   ├── dto/
│   │   ├── ClientDto.java       # Data transfer object for client
│   │   └── WorkoutEntry.java    # DTO for workout entries
│   ├── entity/
│   │   └── Client.java          # JPA entity for client
│   ├── enums/
│   │   └── WorkoutType.java     # Enum for workout types
│   ├── repository/
│   │   └── ClientRepository.java # Repository for client data
│   ├── requestbody/
│   │   └── ClientRequestBody.java # Request object for client operations
│   └── transformer/
│       └── ClientToClientDto.java # Transformer to convert entity to DTO
└── web/
    ├── controller/
    │   └── ClientController.java  # REST controller for client endpoints
    └── graphql/
        └── ClientGraphiqlController.java # GraphQL controller
```

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 21
- PostgreSQL 
- Gradle

### Database Setup

1. Create a PostgreSQL database named 'workoutmanager'
2. Set username and password to 'postgres' or update the credentials in application.properties

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run the application using Gradle:

```bash
./gradlew bootRun
```

Alternatively, build the project and run the JAR file:

```bash
./gradlew build
java -jar build/libs/workoutmanager-0.0.1-SNAPSHOT.jar
```

## API Endpoints

### REST API

- `GET /client/`: Fetch all clients with their workout schedules
- `POST /client/save`: Save a new client with workout information

### GraphQL

- GraphQL UI available at: `/graphiql`
- Query examples:
  ```graphql
  {
    clients {
      id
      name
      workoutOnDay {
        date
        workouts
      }
    }
  }
  ```

## Features and Functionality

- Record workouts for clients with dates
- Support for different workout types (Weight Training, Cardio)
- Retrieve client workout histories
- REST API for traditional HTTP endpoints
- GraphQL API for flexible data queries

## Database Configuration

The application uses PostgreSQL as the database with Flyway for migrations:

- Database: PostgreSQL
- Schema management: Flyway migrations
- Main entities:
  - Client (id, name, date, workout)
  - Trainer (id, name, client_id)

Configuration details are in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/workoutmanager
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.flyway.enabled=true
spring.flyway.url=jdbc:postgresql://localhost:5432/workoutmanager
spring.flyway.user=postgres
spring.flyway.password=postgres
```

## Development

The project is built using Gradle:

```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.3.5'
    id 'io.spring.dependency-management' version '1.1.7'
}
```

## API Documentation

The API is documented using OpenAPI, accessible at `/swagger-ui.html` when the application is running.