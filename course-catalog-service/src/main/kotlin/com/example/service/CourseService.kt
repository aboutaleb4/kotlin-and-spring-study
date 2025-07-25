package com.example.service

import com.example.dto.CourseDTO
import com.example.entity.Course
import com.example.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService( val courseRepository: CourseRepository) {

    fun addCourse(courseDTO: CourseDTO): CourseDTO {
        val courseEntity = courseDTO.let {
            Course(null, it.name, it.category)
        }
        courseRepository.save(courseEntity);

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }
}
