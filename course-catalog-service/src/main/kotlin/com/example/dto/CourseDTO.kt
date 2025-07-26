package com.example.dto

import jakarta.validation.constraints.NotBlank

data class CourseDTO (
    var id: Int?,
    @get: NotBlank(message = "Name cannot be empty")
    var name: String,
    @get: NotBlank(message = "Category cannot be empty")
    var category: String,
)