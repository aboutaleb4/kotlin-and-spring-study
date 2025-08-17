package com.example.controller

import com.example.client.ExternalServiceClient
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoCircuitBreakerController(
    private val externalServiceClient: ExternalServiceClient
) {

    @GetMapping("/resilient-endpoint")
    @CircuitBreaker(name = "myService", fallbackMethod = "fallbackForExternalService")
    fun callExternalService(): String {
        println("Attempting to call external service via Feign...")
        return externalServiceClient.callExternalService("user1")
    }

    fun fallbackForExternalService(t: Throwable): String {
        println("Circuit breaker triggered! Cause: ${t.message}")
        return "Fallback Response: The external service is currently unavailable. Please try again later. 🤷‍♂️"
    }
}