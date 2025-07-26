package com.example.dto

import jakarta.validation.constraints.NotBlank

data class CourseDTO (
    var id: Int?,
    @get: NotBlank(message = "courseDTO.name must not be blank")
    var name: String,
    @get: NotBlank(message = "courseDTO.category must not be blank")
    var category: String,
)