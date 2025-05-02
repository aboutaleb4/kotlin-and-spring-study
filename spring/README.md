# Spring Boot with Kotlin

Spring Boot applications built with Kotlin.

## Projects

- User API - A simple REST API for user management
- More examples coming soon...

## Features

- RESTful APIs
- Dependency injection
- Data persistence
- Testing

## Requirements

- Java 17 or later
- Gradle

## User API

A simple Spring Boot application with Kotlin that provides CRUD operations for User resources.

### API Endpoints

- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Project Structure

```
src/main/kotlin/com/example/
├── Application.kt           # Main application class
├── controller/
│   └── UserController.kt   # REST endpoints
├── model/
│   └── User.kt            # User data class
├── repository/
│   └── UserRepository.kt  # In-memory storage
└── service/
    └── UserService.kt     # Business logic
``` 