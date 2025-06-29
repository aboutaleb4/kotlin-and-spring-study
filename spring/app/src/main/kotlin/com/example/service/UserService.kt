package com.example.service

import com.example.model.User
import com.example.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional // Recommended for database operations

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll() // JpaRepository's findAll() returns List<User> directly
    }

    fun getUserById(id: Long): User? {
        // JpaRepository's findById returns Optional<User>.
        // .orElse(null) converts it to User? (nullable User).
        return userRepository.findById(id).orElse(null)
    }

    @Transactional // Ensures the operation is atomic and committed/rolled back as a single unit
    fun createUser(user: User): User {
        // When creating, the 'id' should typically be null, and the DB generates it.
        // The save method handles both creation (id=null) and update (id present).
        return userRepository.save(user)
    }

    @Transactional // Ensures the operation is atomic
    fun updateUser(id: Long, user: User): User? {
        // 1. Find the existing user by ID
        return userRepository.findById(id).map { existingUser ->
            // 2. If found, create a *new* User object with updated fields
            //    and the original ID to ensure we update the correct record.
            val userToSave = existingUser.copy(name = user.name)
            // You can selectively update properties if not all fields are always provided:
            // if (user.name != null) existingUser.name = user.name
            // if (user.age != null) existingUser.age = user.age

            // 3. Save the modified entity. JpaRepository's save() performs an update
            //    if the entity has an ID that already exists in the database.
            userRepository.save(userToSave)
        }.orElse(null) // If the user with the given ID is not found, return null
    }

    @Transactional // Ensures the operation is atomic
    fun deleteUser(id: Long): Boolean {
        // It's good practice to check if the entity exists before attempting to delete,
        // although deleteById often doesn't throw an exception if not found.
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            true // Indicate successful deletion
        } else {
            false // Indicate user not found
        }
    }
}