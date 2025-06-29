package com.example.repository

import com.example.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// By extending JpaRepository, Spring Data JPA automatically provides
// implementations for common CRUD operations (save, findById, findAll, deleteById, etc.)
@Repository
interface UserRepository : JpaRepository<User, Long> {
    // You can add custom query methods here if needed, e.g.:
    // fun findByName(name: String): List<User>
    // fun findByAgeGreaterThan(age: Int): List<User>
}