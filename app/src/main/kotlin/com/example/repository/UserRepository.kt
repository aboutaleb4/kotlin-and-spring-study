package com.example.repository

import com.example.model.User
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

@Repository
class UserRepository {
    private val users = ConcurrentHashMap<Long, User>()
    private val idCounter = AtomicLong(1)

    fun findAll(): List<User> = users.values.toList()

    fun findById(id: Long): User? = users[id]

    fun save(user: User): User {
        val id = user.id ?: idCounter.getAndIncrement()
        val newUser = user.copy(id = id)
        users[id] = newUser
        return newUser
    }

    fun update(id: Long, user: User): User? {
        if (!users.containsKey(id)) return null
        val updatedUser = user.copy(id = id)
        users[id] = updatedUser
        return updatedUser
    }

    fun deleteById(id: Long): Boolean = users.remove(id) != null
} 