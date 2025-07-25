package com.example.controller

import com.example.dto.CourseDTO
import com.example.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseService: CourseService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCourse(@RequestBody courseDTO: CourseDTO): CourseDTO {
        return courseService.addCourse(courseDTO)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun retrieveAllCourses(): List<CourseDTO> = courseService.getAll()

    @PutMapping("/{course_id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCourse(@RequestBody courseDTO: CourseDTO, @PathVariable("course_id") courseId: Int): CourseDTO {
        return courseService.updateCourse(courseId, courseDTO)
    }

    @DeleteMapping("/{course_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCourse(@PathVariable("course_id") courseId: Int) {
        return courseService.deleteCourse(courseId)
    }
}