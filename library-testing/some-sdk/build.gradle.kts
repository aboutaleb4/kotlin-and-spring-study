plugins {
    kotlin("jvm") version "1.9.22"
    `maven-publish`
}

group = "com.some.sdk"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("main") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            from(components["java"])
        }
    }
}