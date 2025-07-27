package com.example.service

import com.example.dto.CourseDTO
import com.example.entity.Course
import com.example.exceptions.CourseNotFoundException
import com.example.repository.CourseRepository
import org.springframework.stereotype.Service
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

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

    suspend fun getAllCourses(): Flow<CourseDTO> {
        return courseRepository.findAll().map {
            CourseDTO(it.id, it.name, it.category)
        }.asFlow()
    }

    fun updateCourse(courseId: Int, courseDTO: CourseDTO): CourseDTO {
        val existingCourse = courseRepository.findById(courseId)

        return if (existingCourse.isPresent) {
            existingCourse.get().let {
                it.name = courseDTO.name
                it.category = courseDTO.category
                courseRepository.save(it)
                CourseDTO(it.id, it.name, it.category)
            }
        }
        else {
            throw CourseNotFoundException("Course $courseId not found")
        }
    }

    fun deleteCourse(courseId: Int) {
        val existingCourse = courseRepository.findById(courseId)

        return if (existingCourse.isPresent) {
            courseRepository.deleteById(courseId)
        }
        else {
            throw CourseNotFoundException("Course $courseId not found")
        }

    }
}
