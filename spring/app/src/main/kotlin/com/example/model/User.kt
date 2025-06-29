package com.example.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // Make nullable and provide a default null
    val name: String = "", // <--- Provide a default empty string
)