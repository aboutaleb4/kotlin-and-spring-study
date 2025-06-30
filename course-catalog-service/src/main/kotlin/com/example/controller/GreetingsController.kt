package com.example.controller

import com.example.service.GreetingsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingsController(val greetingsService: GreetingsService) {
    @GetMapping("/{name}")
    fun retrieveGreetings(@PathVariable("name") name: String): String {

        return greetingsService.greeting(name)
    }
}