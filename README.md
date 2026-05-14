# Chronos Replica

## Project Overview
Chronos Replica is a comprehensive scheduling, shift bidding, and payroll management platform. It provides a robust, air-gapped capable backend for workforce management.

## Project Topology
```text
JRM/
├── api/                # API Endpoints & Entry Point
├── core/               # Business Logic & DTOs
├── domain/             # Entities & Repositories
├── security/           # JWT & Security Logic
├── docker-compose.yml  # Database & Infrastructure
└── BLUEPRINT.md        # Technical Specifications
```

## Key Features
- **Smart Scheduling**: Automate shift creation based on location and department needs.
- **Dynamic Bidding**: Allow employees to bid on open shifts with administrative approval workflows.
- **Secure Identity**: Role-Based Access Control (RBAC) powered by JWT.
- **Audit-Ready**: Every change is tracked via Hibernate Envers for compliance.
- **Integrated Payroll**: Automatic hour tracking linked to verified time entries and pay period processing.
- **Real-Time Tracking**: Clock-in/out mechanics with automated duration calculation.

## How to Use
1. **Initialize the Database**: Use `docker-compose up -d` to start the PostgreSQL instance.
2. **Build the Project**: Run `mvn clean install` from the root directory.
3. **Explore APIs**: Once running, access the Swagger documentation at `/swagger-ui.html` to test endpoints like `/users`, `/shifts`, and `/employee-profiles`.
4. **Configure Environments**: Use `application-dev.yml` for local testing or set environment variables for production deployments.

## Getting Started (Quick Command)
```bash
# Clone and Build
git clone https://github.com/your-github-username/JRM.git && cd JRM && mvn clean install
```

For detailed technical logic and implementation snippets, see [BLUEPRINT.md](./BLUEPRINT.md).
