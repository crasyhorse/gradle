rootProject.name = "unit-converter-gradle"
include("converter-core", "unit-converter-cli")

project(":unit-converter-cli").projectDir = file("converter-cli")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}  

plugins {
    id("io.github.ben-manes.versions") version "0.67.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}
