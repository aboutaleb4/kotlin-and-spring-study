subprojects {
    pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
        configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
            jvmToolchain(21)
        }
    }
}
