package com.example.repository

import com.example.model.User
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class UserRepositoryTest {
    private lateinit var repository: UserRepository

    @BeforeEach
    fun setUp() {
        repository = UserRepository()
    }

    @Test
    fun `should save and find user`() {
        val user = User(1L, "John Doe")
        repository.save(user)
        
        val found = repository.findById(1L)
        assertEquals(user, found)
    }

    @Test
    fun `should return null when user not found`() {
        val found = repository.findById(999L)
        assertNull(found)
    }

    @Test
    fun `should find all users`() {
        val user1 = User(1L, "John Doe")
        val user2 = User(2L, "Jane Doe")
        
        repository.save(user1)
        repository.save(user2)
        
        val allUsers = repository.findAll()
        assertEquals(2, allUsers.size)
        assertTrue(allUsers.contains(user1))
        assertTrue(allUsers.contains(user2))
    }

    @Test
    fun `should update user`() {
        val user = User(1L, "John Doe")
        repository.save(user)
        
        val updatedUser = User(1L, "Jane Doe")
        val result = repository.update(1L, updatedUser)
        
        assertEquals(updatedUser, result)
        assertEquals(updatedUser, repository.findById(1L))
    }

    @Test
    fun `should delete user`() {
        val user = User(1L, "John Doe")
        repository.save(user)
        
        val deleted = repository.deleteById(1L)
        assertTrue(deleted)
        assertNull(repository.findById(1L))
    }
} 