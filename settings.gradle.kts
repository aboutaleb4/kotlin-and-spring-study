rootProject.name = "learn-kotlin"
include("spring:app")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("spring/gradle/libs.versions.toml"))
        }
    }
} 