package com.example.controller

import com.example.dto.CourseDTO
import com.example.service.CourseService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
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

}