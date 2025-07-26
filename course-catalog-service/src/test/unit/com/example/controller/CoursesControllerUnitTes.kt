package com.example.controller

import com.example.dto.CourseDTO
import com.example.service.CourseService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient
import utils.courseDTO
import utils.courseEntityList

@WebMvcTest(controllers = [CourseController::class])
@AutoConfigureWebTestClient
class CoursesControllerUnitTes {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var coursesServiceMock: CourseService

    @Test
    fun retrieveGreeting() {
        every { coursesServiceMock.addCourse(any()) }.returns(courseDTO(id = 1))

        val responseBody = webTestClient.post()
            .uri("/v1/courses")
            .bodyValue(courseDTO())
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            responseBody!!.id != null
        }
    }

    @Test
    fun retrieveAllCourses() {
        every { coursesServiceMock.getAll() }
            .returns(courseEntityList().map { CourseDTO(it.id, it.name, it.category) })

        val responseBody = webTestClient.get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        println(responseBody)
        Assertions.assertTrue {
            responseBody!!.size == 3
        }
    }

    @Test
    fun updateCourse() {
        val courseDTO = CourseDTO(1,
            "Apache Kafka for Developers using Spring Boot1", "Development" )

        every { coursesServiceMock.updateCourse(any(), any()) }
            .returns( courseDTO)


        val updatedCourseDTO = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", courseDTO.id)
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals("Apache Kafka for Developers using Spring Boot1", updatedCourseDTO?.name)
    }


}