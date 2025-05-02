plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
    kotlin("jvm") version "1.9.22" apply false
}

rootProject.name = "learn-kotlin"
include("spring:app")
include("design-patterns:structural:facade")
include("basics")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("spring/gradle/libs.versions.toml"))
        }
    }
}
