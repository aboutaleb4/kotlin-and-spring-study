package com.example.service

import com.example.model.User
import com.example.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User? = userRepository.findById(id)

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(id: Long, user: User): User? = userRepository.update(id, user)

    fun deleteUser(id: Long): Boolean = userRepository.deleteById(id)
} 