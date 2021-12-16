import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "me.lawos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

javafx {
    version = "17"
    modules = listOf("javafx.controls")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-RC2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.6.0-RC2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
