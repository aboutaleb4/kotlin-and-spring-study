plugins {
    kotlin("jvm")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("com.some.implementer:some-implementer:0.0.1-SNAPSHOT")
    implementation("com.some.sdk:some-sdk:0.0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}