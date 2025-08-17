package com.example.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "externalService", url = "http://api-gateway-demo:8084")
interface ExternalServiceClient {
    @GetMapping("/anything/test")
    fun callExternalService(@RequestParam client: String = "user1"): String
}