rootProject.name = "learn-kotlin"
include("spring:app")
include("design-patterns:structural:facade")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("spring/gradle/libs.versions.toml"))
        }
    }
} 