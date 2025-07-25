package com.example.entity

import jakarta.persistence.*

@Entity
@Table(name = "COURSES")
data class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    val name: String,
    val category: String,
){
    constructor() : this(null, "", "")
}