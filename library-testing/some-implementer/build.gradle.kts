plugins {
    kotlin("jvm") version "1.9.22"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library-testing:some-sdk"))
}