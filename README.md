Add# Spring Boot Kotlin User API

A simple Spring Boot application with Kotlin that provides CRUD operations for User resources.

## Features

- RESTful API for User management
- In-memory storage
- CRUD operations (Create, Read, Update, Delete)
- Built with Spring Boot and Kotlin

## Project Structure

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

## API Endpoints

### Get All Users
```bash
GET /api/users
```
Returns a list of all users.

### Get User by ID
```bash
GET /api/users/{id}
```
Returns a specific user by ID.

### Create User
```bash
POST /api/users
Content-Type: application/json

{
    "name": "John Doe"
}
```
Creates a new user. The ID will be automatically generated.

### Update User
```bash
PUT /api/users/{id}
Content-Type: application/json

{
    "name": "Jane Doe"
}
```
Updates an existing user.

### Delete User
```bash
DELETE /api/users/{id}
```
Deletes a user by ID.

## Getting Started

### Prerequisites

- Java 17 or later
- Gradle

### Running the Application

1. Clone the repository
2. Run the application:
```bash
./gradlew bootRun
```

The application will start on http://localhost:8080

### Building the Application

```bash
./gradlew build
```

## Technologies Used

- Spring Boot 3.2.3
- Kotlin 1.9.22
- Gradle
- Jackson for JSON serialization 