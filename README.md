# Chronos Replica

## Project Overview
Chronos Replica is a comprehensive scheduling, shift bidding, and payroll management platform.

## Architecture
- **Monolithic Spring Boot Java Architecture**
- **Multimodule Structure**:
  - `core`: Services and business logic.
  - `domain`: JPA entities and repositories.
  - `security`: Security configuration and JWT.
  - `api`: REST Controllers and Application Entry point.

## Tech Stack
- Java 17
- Spring Boot 3
- PostgreSQL (Database)
- Redis (Caching)
- Mailhog (Local Email Testing)
- Lombok
- MapStruct
- Flyway (Database Migrations)
- SpringDoc OpenAPI (Swagger)

## Getting Started

### Prerequisites
- JDK 17
- Maven
- Docker & Docker Compose

### Running Locally
1. Start infrastructure services:
   ```bash
   docker-compose up -d
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run -pl api
   ```

## Development Standards
- **Checkstyle**: Google Java Style.
- **SpotBugs**: Static analysis for bugs.
- **Git Branching**: `main` (production), `develop` (feature integration).
