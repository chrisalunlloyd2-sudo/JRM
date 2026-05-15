# Chronos Replica - System Blueprint

## Project Goal
Build a high-performance, monolithic Spring Boot backend for "Chronos Replica", focused on shift bidding, automated scheduling, and payroll management with full auditability and secure access.

## Project Topology
```text
JRM/
├── api/                # REST Controller & App Entry
│   └── src/main/java/com/jrm/chronos/api/
│       ├── ChronosApplication.java
│       └── GlobalExceptionHandler.java
├── core/               # Business Logic & DTOs
│   └── src/main/java/com/jrm/chronos/core/
│       ├── dto/        # Data Transfer Objects
│       ├── mapper/     # MapStruct Mappers
│       └── service/    # Service Interfaces & Impl
├── domain/             # Entities & Repositories
│   ├── src/main/java/com/jrm/chronos/domain/
│   │   ├── enums/      # Status Enums (Shift, Bid)
│   │   └── repository/ # JPA/QueryDSL Repositories
│   └── src/main/resources/db/migration/ # Flyway SQL scripts
├── security/           # JWT & Spring Security
├── docker-compose.yml  # Infrastructure (Postgres, Redis, Sonar)
├── pom.xml             # Parent Maven POM
└── README.md           # User Documentation
```

## Feature Matrix

| Feature | Description | Status |
| :--- | :--- | :--- |
| **Identity Management** | RBAC (Role-Based Access Control) with JWT security. | Active |
| **Org Structure** | Management of Locations and Departments. | Active |
| **Employee Profiles** | Personal and professional data linked to system users. | Active |
| **Shift Scheduling** | Creation and management of work slots per location/dept. | Active |
| **Shift Bidding** | Mechanism for employees to bid on open shifts. | Active |
| **Payroll Processing** | Tracking time entries and generating paychecks. | Active |
| **Time Tracking** | Real-time clock-in/out and automated hour calculation. | Active |
| **Full Auditing** | Hibernate Envers tracking for every entity change. | Active |
| **Mobile UI Prototype** | Android APK prototype featuring dark mode, tabbed navigation, sticky notes, and secure DB profile viewer. | Active |

## Performative Code Snippets

### 1. Base Auditing (Performative Foundation)
```java
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate @Column(updatable = false) private LocalDateTime createdAt;
    @LastModifiedDate private LocalDateTime updatedAt;
}
```

### 2. Standardized API Responses
```java
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
```

## Installation & Build Guide (Step-by-Step)

### Phase 1: Environment Setup
1. **Clone Repository:**
   ```bash
   git clone https://github.com/your-github-username/JRM.git
   cd JRM
   ```
2. **Start Infrastructure:** (Requires Docker)
   ```bash
   docker-compose up -d
   ```

### Phase 2: Building the Project
Execute these commands sequentially to ensure each module compiles correctly:

1. **Clean and Install Parent:**
   ```bash
   mvn clean install -N
   ```
2. **Build Domain Module:**
   ```bash
   mvn install -pl domain
   ```
3. **Build Core Logic:**
   ```bash
   mvn install -pl core
   ```
4. **Build Security Module:**
   ```bash
   mvn install -pl security
   ```
5. **Final API Compilation:**
   ```bash
   mvn package -pl api
   ```

### Phase 3: Running the Application
1. **Run Spring Boot:**
   ```bash
   mvn spring-boot:run -pl api
   ```
2. **Access Swagger UI:**
   Navigate to `http://localhost:8080/swagger-ui.html`

## GitHub Deployment Commands (Prompt)
*Execute these commands to populate your remote repository:*
```bash
git remote add origin https://github.com/your-github-username/JRM.git
git branch -M main
git push -u origin main
```
