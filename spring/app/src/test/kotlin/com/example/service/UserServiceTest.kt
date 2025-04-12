package com.example.service

import com.example.model.User
import com.example.repository.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class UserServiceTest {
    private lateinit var service: UserService
    private lateinit var repository: UserRepository

    @BeforeEach
    fun setUp() {
        repository = UserRepository()
        service = UserService(repository)
    }

    @Test
    fun `should get all users`() {
        val user1 = User(1L, "John Doe")
        val user2 = User(2L, "Jane Doe")
        
        repository.save(user1)
        repository.save(user2)
        
        val allUsers = service.getAllUsers()
        assertEquals(2, allUsers.size)
        assertTrue(allUsers.contains(user1))
        assertTrue(allUsers.contains(user2))
    }

    @Test
    fun `should get user by id`() {
        val user = User(1L, "John Doe")
        repository.save(user)
        
        val found = service.getUserById(1L)
        assertEquals(user, found)
    }

    @Test
    fun `should create user`() {
        val user = User(1L, "John Doe")
        val created = service.createUser(user)
        
        assertEquals(user, created)
        assertEquals(user, service.getUserById(1L))
    }

    @Test
    fun `should update user`() {
        val user = User(1L, "John Doe")
        repository.save(user)
        
        val updatedUser = User(1L, "Jane Doe")
        val result = service.updateUser(1L, updatedUser)
        
        assertEquals(updatedUser, result)
        assertEquals(updatedUser, service.getUserById(1L))
    }

    @Test
    fun `should delete user`() {
        val user = User(1L, "John Doe")
        repository.save(user)
        
        val deleted = service.deleteUser(1L)
        assertTrue(deleted)
        assertNull(service.getUserById(1L))
    }
} 