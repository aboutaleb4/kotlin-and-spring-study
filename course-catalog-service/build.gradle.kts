import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"

    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.spring)
    application
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {

    //web
    implementation("org.springframework.boot:spring-boot-starter-web")

    //web
    implementation("org.springframework.boot:spring-boot-starter-validation")

    //kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    //validator
    implementation("org.springframework.boot:spring-boot-starter-validation")

    //logging
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")

    implementation("org.springframework.boot:spring-boot-starter-actuator")

    //db
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // For tests:
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")

    runtimeOnly("com.h2database:h2")
//    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("io.mockk:mockk:1.10.4")
    testImplementation("com.ninja-squad:springmockk:3.0.1")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

sourceSets {
    test {
        java {
            srcDirs("src/test/intg", "src/test/unit")
        }
    }
}