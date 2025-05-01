plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
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
