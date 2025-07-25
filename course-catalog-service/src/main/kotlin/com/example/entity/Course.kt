package com.example.entity

import jakarta.persistence.*

@Entity
@Table(name = "COURSES")
data class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,
    var name: String,
    var category: String,
){
    constructor() : this(null, "", "")
}