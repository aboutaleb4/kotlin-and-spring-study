package com.example.controller

import com.example.dto.CourseDTO
import com.example.service.CourseService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.coEvery
import io.mockk.every
import kotlinx.coroutines.flow.asFlow // Import this for List.asFlow()
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
    fun addCourse() {
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
        coEvery { coursesServiceMock.getAllCourses() }
            .returns(courseEntityList().map { CourseDTO(it.id, it.name, it.category) }.asFlow())

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

    @Test
    fun addCourse_validation() {
        every { coursesServiceMock.addCourse(any()) }.returns(courseDTO(id = 1))

        val responseBody = webTestClient.post()
            .uri("/v1/courses")
            .bodyValue(CourseDTO(null, "", ""))
            .exchange()
            .expectStatus().isBadRequest
            .expectBody(String::class.java)
            .returnResult()
            .responseBody

        assertEquals("courseDTO.category must not be blank,courseDTO.name must not be blank"
            , responseBody)
    }

    @Test
    fun addCourse_runtimeException() {
        val message = "Random Exception"
        every { coursesServiceMock.addCourse(any()) } throws RuntimeException(message)

        val responseBody = webTestClient.post()
            .uri("/v1/courses")
            .bodyValue(CourseDTO(null, "name", "category"))
            .exchange()
            .expectStatus().is5xxServerError
            .expectBody(String::class.java)
            .returnResult()
            .responseBody

        assertEquals(message, responseBody)
    }
}