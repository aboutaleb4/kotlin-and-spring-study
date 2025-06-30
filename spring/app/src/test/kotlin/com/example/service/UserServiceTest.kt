package com.example.service

import com.example.model.User
import com.example.repository.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.assertFalse

// @ExtendWith(MockitoExtension::class) enables Mockito annotations like @Mock and @InjectMocks
@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    // @Mock creates a mock instance of UserRepository
    @Mock
    private lateinit var userRepository: UserRepository

    // @InjectMocks creates an instance of UserService and injects the mocks
    // (like userRepository) into it.
    @InjectMocks
    private lateinit var userService: UserService

    // We no longer need to clear data explicitly as we are using mocks,
    // and each test runs with a fresh mock instance.
    @BeforeEach
    fun setUp() {
        // Reset mocks before each test to ensure a clean state
        // This is good practice to prevent test interactions from affecting subsequent tests.
        Mockito.reset(userRepository)
    }

    @Test
    fun `should get all users`() {
        // Arrange: Define the behavior of the mocked userRepository
        val user1 = User(id = 1L, name = "John Doe")
        val user2 = User(id = 2L, name = "Jane Doe")
        val users = listOf(user1, user2)

        // When userRepository.findAll() is called, return our predefined list of users
        Mockito.`when`(userRepository.findAll()).thenReturn(users)

        // Act: Call the method under test
        val allUsers = userService.getAllUsers()

        // Assert: Verify the results and that the mock method was called
        assertEquals(2, allUsers.size)
        assertTrue(allUsers.contains(user1))
        assertTrue(allUsers.contains(user2))

        // Verify that findAll() was called exactly once on the mock
        Mockito.verify(userRepository, Mockito.times(1)).findAll()
    }

    @Test
    fun `should get user by id`() {
        // Arrange
        val userId = 1L
        val user = User(id = userId, name = "John Doe")

        // Mock userRepository.findById() to return an Optional containing our user
        Mockito.`when`(userRepository.findById(userId)).thenReturn(Optional.of(user))

        // Act
        val found = userService.getUserById(userId)

        // Assert
        assertNotNull(found)
        assertEquals(user, found)

        // Verify that findById() was called exactly once with the correct ID
        Mockito.verify(userRepository, Mockito.times(1)).findById(userId)
    }

    @Test
    fun `should return null for non-existent user id`() {
        // Arrange
        val nonExistentId = 999L

        // Mock userRepository.findById() to return an empty Optional
        Mockito.`when`(userRepository.findById(nonExistentId)).thenReturn(Optional.empty())

        // Act
        val found = userService.getUserById(nonExistentId)

        // Assert
        assertNull(found)

        // Verify that findById() was called exactly once with the correct ID
        Mockito.verify(userRepository, Mockito.times(1)).findById(nonExistentId)
    }

    @Test
    fun `should create user`() {
        // Arrange
        val userToCreate = User(name = "John Doe")
        // Simulate the database assigning an ID upon save
        val createdUserWithId = User(id = 1L, name = "John Doe")

        // Mock userRepository.save() to return the user with a generated ID
        // The argument `userToCreate` passed to save() should match the one provided to the service.
        Mockito.`when`(userRepository.save(userToCreate)).thenReturn(createdUserWithId)

        // Act
        val createdUser = userService.createUser(userToCreate)

        // Assert
        assertNotNull(createdUser.id)
        assertEquals("John Doe", createdUser.name)
        assertEquals(createdUserWithId, createdUser)

        // Verify that save() was called exactly once with the user to create
        Mockito.verify(userRepository, Mockito.times(1)).save(userToCreate)
    }

    @Test
    fun `should update user`() {
        // Arrange
        val userId = 1L
        val existingUser = User(id = userId, name = "John Doe")
        val updatedUserRequest = User(id = userId, name = "Jane Smith")
        val savedUpdatedUser = User(id = userId, name = "Jane Smith") // What save() would return

        // Mock findById to return the existing user
        Mockito.`when`(userRepository.findById(userId)).thenReturn(Optional.of(existingUser))
        // Mock save to return the updated user
        Mockito.`when`(userRepository.save(updatedUserRequest)).thenReturn(savedUpdatedUser)

        // Act
        val result = userService.updateUser(userId, updatedUserRequest)

        // Assert
        assertNotNull(result)
        assertEquals(userId, result.id)
        assertEquals("Jane Smith", result.name)
        assertEquals(savedUpdatedUser, result)

        // Verify calls
        Mockito.verify(userRepository, Mockito.times(1)).findById(userId)
        Mockito.verify(userRepository, Mockito.times(1)).save(updatedUserRequest)
    }

    @Test
    fun `should not update non-existent user`() {
        // Arrange
        val nonExistentId = 999L
        val updatedUser = User(id = nonExistentId, name = "Non Existent")

        // Mock findById to return empty Optional, indicating user not found
        Mockito.`when`(userRepository.findById(nonExistentId)).thenReturn(Optional.empty())

        // Act
        val result = userService.updateUser(nonExistentId, updatedUser)

        // Assert
        assertNull(result)

        // Verify that findById was called, but save was NOT called
        Mockito.verify(userRepository, Mockito.times(1)).findById(nonExistentId)
        Mockito.verify(userRepository, Mockito.never()).save(Mockito.any(User::class.java))
    }

    @Test
    fun `should delete user`() {
        // Arrange
        val userId = 1L
        val userToDelete = User(id = userId, name = "John Doe")

        // Mock findById to return the user to be deleted
//        Mockito.`when`(userRepository.findById(userId)).thenReturn(Optional.of(userToDelete))
        // Mock existsById to return true initially, then false after deletion
        Mockito.`when`(userRepository.existsById(userId))
            .thenReturn(true) // Before deletion check
            .thenReturn(false) // After deletion check (e.g., if service checks again)

        // Act
        val deleted = userService.deleteUser(userId)

        // Assert
        assertTrue(deleted)

        // Verify that findById was called once to check existence
        Mockito.verify(userRepository, Mockito.times(1)).existsById(userId)
        // Verify that deleteById was called exactly once with the correct ID
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(userId)
    }

    @Test
    fun `should not delete non-existent user`() {
        // Arrange
        val nonExistentId = 999L

        // Mock findById to return empty Optional, indicating user not found
        Mockito.`when`(userRepository.existsById(nonExistentId)).thenReturn(false)

        // Act
        val deleted = userService.deleteUser(nonExistentId)

        // Assert
        assertFalse(deleted)

        // Verify that findById was called, but deleteById was NOT called
        Mockito.verify(userRepository, Mockito.times(1)).existsById(nonExistentId)
        Mockito.verify(userRepository, Mockito.never()).deleteById(Mockito.anyLong())
    }
}