plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.spring)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // WebFlux (required for Spring Cloud Gateway)
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Spring Cloud Gateway
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    // AOP (needed if you use circuit breaker / resilience filters)
    implementation("org.springframework.boot:spring-boot-starter-aop")

    // Optional: JSON support for Kotlin data classes
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Add resilience4j for circuit breaker support
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j")

    // Redis rate limiter support
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.example.ApiGatewayApplicationKt"
}