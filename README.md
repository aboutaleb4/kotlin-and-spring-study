# Spring Boot Kotlin User API

A modern, lightweight RESTful API built with Spring Boot and Kotlin for managing user resources. This project demonstrates best practices in building microservices with Spring Boot and Kotlin, featuring clean architecture, dependency injection, and comprehensive CRUD operations.

## 🚀 Features

- RESTful API for User management
- In-memory storage
- CRUD operations (Create, Read, Update, Delete)
- Built with Spring Boot and Kotlin
- Clean architecture and separation of concerns
- Comprehensive error handling
- JSON serialization with Jackson

## 📁 Project Structure

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

## 🔌 API Endpoints

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

## 🛠️ Getting Started

### Prerequisites

- Java 17 or later
- Gradle
- Git

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/spring-boot-kotlin-user-api.git
cd spring-boot-kotlin-user-api
```

2. Build the project:
```bash
./gradlew build
```

3. Run the application:
```bash
./gradlew bootRun
```

The application will start on http://localhost:8080

## 🧪 Testing

Run the test suite:
```bash
./gradlew test
```

## 📚 Technologies Used

- Spring Boot 3.2.3
- Kotlin 1.9.22
- Gradle
- Jackson for JSON serialization
- JUnit for testing

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Spring Boot team for the amazing framework
- Kotlin team for the wonderful language
- All contributors who have helped improve this project 

# Learn Kotlin

A collection of Kotlin learning modules covering different aspects of the language and its ecosystem.

## Modules

- [basics](basics/README.md) - Basic Kotlin language features and syntax
- [design-patterns](design-patterns/README.md) - Implementation of common design patterns in Kotlin
- [spring](spring/README.md) - Spring Boot applications built with Kotlin

## Requirements

- Java 17 or later
- Gradle 