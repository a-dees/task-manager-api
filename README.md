# task-manager-api

A RESTful Task Manager API built with Spring Boot, PostgreSQL, and JWT authentication.

This project supports:
- User registration/login
- JWT-based authentication
- Protected API endpoints
- Full CRUD operations for tasks
- PostgreSQL persistence
- Validation and custom exception handling

## Tech Stack
- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- PostgreSQL
- Spring Data JPA
- Maven
- Postman

## Features
- Register new users
- Login with JWT authentication
- Secure protected endpoints
- Create tasks
- View all tasks
- View task by ID
- Update tasks
- Delete tasks
- Custom exception handling
- Request validation

## API Endpoints

### Authentication
POST /auth/register  
POST /auth/login

### Tasks
GET /tasks  
GET /tasks/{id}  
POST /tasks  
PUT /tasks/{id}  
DELETE /tasks/{id}

