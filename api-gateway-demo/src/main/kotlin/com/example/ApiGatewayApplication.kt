package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Mono

@SpringBootApplication
class ApiGatewayApplication {

    @Bean
    fun clientKeyResolver(): KeyResolver {
        return KeyResolver { exchange ->
            Mono.just(exchange.request.queryParams.getFirst("client") ?: "anonymous")
        }
    }

    @Bean
    fun redisRateLimiter(): RedisRateLimiter {
        return RedisRateLimiter(1, 5) // 1 token/sec, burst 5 → ~5 requests per 10 seconds
    }

    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route("limit_route") { r ->
                r.path("/anything/**")
                    .filters { f -> f.requestRateLimiter { it.setRateLimiter(redisRateLimiter()) } }
                    .uri("https://httpbin.org")
            }
            .build()
    }
}

fun main(args: Array<String>) {
    runApplication<ApiGatewayApplication>(*args)
}