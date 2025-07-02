package com.example.controller

import com.example.service.GreetingsService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/health-check")
class HealthCheckController(val greetingsService: GreetingsService) {
    companion object: KLogging()
    @GetMapping()
    fun healthCheck() {}
}