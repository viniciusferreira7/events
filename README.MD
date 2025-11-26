# ⚠️ WIP

## Events API

A Spring Boot application for managing events with PostgreSQL database, Flyway migrations, and Hibernate ORM.

### Prerequisites

- Java 17+
- Maven 3.8+
- Docker & Docker Compose

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

### Configuration

- **Database**: PostgreSQL (configurable via `.env`)
- **Migrations**: Flyway (located in `src/main/resources/db/migration/`)
- **ORM**: Hibernate with JPA
- **API Documentation**: Swagger UI available at `http://localhost:8080/swagger-ui.html`

### Project Structure

```
src/
├── main/
│   ├── java/
│   └── resources/
│       ├── application.yml (Spring Boot configuration)
│       └── db/migration/ (Flyway migration scripts)
└── test/
```

### Environment Variables

See `.env.example` for all available configuration options.

### Useful Commands

- **Stop PostgreSQL**: `docker-compose down`
- **View logs**: `docker-compose logs -f postgres`
- **Run tests**: `./mvn test`
- **Build**: `./mvn clean package`