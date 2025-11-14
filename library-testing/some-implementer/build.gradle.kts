plugins {
    kotlin("jvm") version "1.9.22"
    `maven-publish`
}

group = "com.some.implementer"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("com.some.sdk:some-sdk:0.0.1-SNAPSHOT")
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