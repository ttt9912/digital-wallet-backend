# Scope
The scope of this work increment aims to provide a simple web application integrated with the NatWest API using the Open Banking Standards. The goal is to provide the user with an overview of their bank accounts, including per-account details.

![Scope](img/Scope.png)

# Constraints
Due to time limitations, some features have been considered out-of-scope, including:
- Proper setup of Authorization and Authentication
- Consent flow
- User management

# System overview
![System overview](img/SystemOverview.png)
- Frontend: Angular Single Page Application
- Backend: Spring Boot Web Application

# Backend Architecture
![Backend architecture](img/BackendArchitecture.png)

Diagram shows the backend modules and their dependencies.

# Improvements
What needs to be done to run and maintain this app in a productive environment?

### Features
- Proper setup of Authorization and Authentication
- Consent flow
- User management
- Error handling
- UX

### Technical
- Deployment based on requirements regarding availability, scalability, etc.
- Frontend to Backend SSL
- CI/CD pipeline
- Automated testing
- Generate REST client from API spec
- Logs and Metrics, Alerting
