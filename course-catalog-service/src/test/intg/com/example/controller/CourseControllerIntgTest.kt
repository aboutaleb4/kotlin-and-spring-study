package com.example.controller

import com.example.dto.CourseDTO
import com.example.entity.Course
import com.example.repository.CourseRepository
import utils.courseEntityList
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CourseControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setUp() {
        courseRepository.deleteAll()
        courseRepository.saveAll(courseEntityList())
    }

    @Test
    fun addCourse() {
        val courseDto = CourseDTO(null, "Math", "Science")

        val responseBody = webTestClient.post()
            .uri("v1/courses")
            .bodyValue(courseDto)
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
        val responseBody = webTestClient.get()
            .uri("v1/courses")
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
        val courseEntity = Course(
            null,
            "Apache Kafka for Developers using Spring Boot", "Development"
        )
        courseRepository.save(courseEntity)
        val updatedCourseEntity = Course(null,
            "Apache Kafka for Developers using Spring Boot1", "Development" )

        val updatedCourseDTO = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", courseEntity.id)
            .bodyValue(updatedCourseEntity)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals("Apache Kafka for Developers using Spring Boot1", updatedCourseDTO?.name)
    }

    @Test
    fun deleteCourse() {

        val courseEntity = Course(null,
            "Apache Kafka for Developers using Spring Boot", "Development")

        courseRepository.save(courseEntity)
        webTestClient
            .delete()
            .uri("/v1/courses/{courseId}", courseEntity.id)
            .exchange()
            .expectStatus().isNoContent

    }

}