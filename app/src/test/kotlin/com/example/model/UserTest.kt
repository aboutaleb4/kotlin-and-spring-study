package com.example.model

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class UserTest {
    @Test
    fun `should create user with id and name`() {
        val user = User(1L, "John Doe")
        assertEquals(1L, user.id)
        assertEquals("John Doe", user.name)
    }

    @Test
    fun `should create user with different values`() {
        val user = User(2L, "Jane Doe")
        assertEquals(2L, user.id)
        assertEquals("Jane Doe", user.name)
    }
} 