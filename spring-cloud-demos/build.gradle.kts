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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}

dependencyManagement {
    imports {
        mavenBom( "org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.example.ApplicationKt"
}
