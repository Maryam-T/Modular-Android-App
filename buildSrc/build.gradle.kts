import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    maven("https://maven.google.com")
    google()
    jcenter()
    mavenCentral()
    maven("https://jitpack.io")
}