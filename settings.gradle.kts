plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
    kotlin("jvm") version "1.9.22" apply false
}

rootProject.name = "kotlin-and-spring-study"
include("spring:app")
include("design-patterns:structural:facade")
include("basics")
include("course-catalog-service")

// Included the projects that are already part of my codebase.
// Does the codebase necessarily have to have all of them?

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("spring/gradle/libs.versions.toml"))
        }
    }
}

