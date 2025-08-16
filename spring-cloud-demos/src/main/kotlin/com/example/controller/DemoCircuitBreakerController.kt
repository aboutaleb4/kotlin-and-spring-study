package com.example.controller

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class DemoCircuitBreakerController {

    private val restTemplate = RestTemplate()
    private val externalServiceUrl = "http://localhost:8081/unstable-api" // URL of a fake unstable service

    @GetMapping("/resilient-endpoint")
    @CircuitBreaker(name = "myService", fallbackMethod = "fallbackForExternalService")
    fun callExternalService(): String {
        println("Attempting to call external service...")
        return restTemplate.getForObject(externalServiceUrl, String::class.java) ?: "External Service Error"
    }

    // This is the fallback method. It must have the same arguments as the original method,
    // plus an optional Throwable parameter to get the cause of the failure.
    fun fallbackForExternalService(t: Throwable): String {
        println("Circuit breaker is open! The fallback method was triggered due to: ${t.message}")
        return "Fallback Response: The external service is currently unavailable. Please try again later. 🤷‍♂️"
    }
}