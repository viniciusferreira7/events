# ⚠️ WIP

## Events API

A Spring Boot application for managing events and users, built with Clean Architecture principles, PostgreSQL database, Flyway migrations, and Hibernate ORM.

### Prerequisites

- Java 17+
- Maven 3.8+
- Docker & Docker Compose

### Features

- Create and manage events with sponsor, location, capacity, and timing details
- User management with email validation
- RESTful API with OpenAPI/Swagger documentation
- Clean Architecture with separation of concerns (Core + Infrastructure layers)
- Database migrations with Flyway
- JPA/Hibernate ORM with PostgreSQL

### Setup

1. Clone the repository
2. Copy `.env.example` to `.env` and update values if needed:
   ```bash
   cp .env.example .env
   ```

3. Start PostgreSQL with Docker Compose:
   ```bash
   docker-compose up -d
   ```

4. Run the application:
   ```bash
   ./mvn spring-boot:run
   ```

### API Endpoints

- **POST** `/api/v1/events` - Create a new event
- **POST** `/api/v1/users` - Create a new user

Access the full API documentation at `http://localhost:8080/swagger-ui.html`

### Configuration

- **Database**: PostgreSQL (configurable via `.env`)
- **Migrations**: Flyway (located in `src/main/resources/db/migration/`)
- **ORM**: Hibernate with JPA
- **API Documentation**: Swagger UI available at `http://localhost:8080/swagger-ui.html`

### Project Structure

```
src/main/java/com/example/events/
├── core/                          # Domain layer (business logic)
│   ├── entities/                  # Domain entities (Event, User)
│   ├── enums/                     # Domain enums (EventType)
│   ├── gateway/                   # Gateway interfaces
│   └── usecases/                  # Use cases (business rules)
│       ├── CreateEventUseCase
│       └── CreateUserUseCase
└── infra/                         # Infrastructure layer
    ├── config/                    # Spring configuration
    ├── dto/                       # Data Transfer Objects
    ├── gateway/                   # Gateway implementations
    │   ├── EventRepositoryGateway
    │   └── UserRepositoryGateway
    ├── mapper/                    # Entity/DTO mappers
    │   ├── EventDtoMapper
    │   ├── EventEntityMapper
    │   ├── UserDtoMapper
    │   └── UserEntityMapper
    ├── persistence/               # JPA entities & repositories
    │   ├── EventEntity
    │   ├── EventsRepository
    │   ├── UserEntity
    │   └── UserRepository
    └── presentation/              # REST controllers
        ├── EventsController
        └── UserController
```

### Architecture

This project follows **Clean Architecture** principles:

- **Core Layer**: Contains business logic, domain entities, and use cases. Independent of frameworks and external dependencies.
- **Infrastructure Layer**: Handles external concerns like database persistence, REST controllers, and framework configurations.
- **Dependency Rule**: Dependencies point inward. The core layer has no knowledge of the infrastructure layer.

### Environment Variables

See `.env.example` for all available configuration options.

### Useful Commands

- **Stop PostgreSQL**: `docker-compose down`
- **View logs**: `docker-compose logs -f postgres`
- **Run tests**: `./mvn test`
- **Build**: `./mvn clean package`