package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(exclude = [org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration::class])
@EnableFeignClients(basePackages = ["com.example"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@RestController
class HelloController {
    @GetMapping("/")
    fun hello(): String {
        return "Hello, World!!!"
    }
}