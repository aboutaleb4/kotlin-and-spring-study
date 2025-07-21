package com.example.controller

import com.example.service.GreetingsService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingsController(val greetingsService: GreetingsService) {
    companion object: KLogging() //In order to be able to use this I had to add a dependency to build.gradle.kts
    @GetMapping("/{name}")
    fun retrieveGreetings(@PathVariable("name") name: String): String {
        logger.info { "Name is $name" }
        return greetingsService.greeting(name)
    }
}