plugins {
    application
}

dependencies {
    implementation(project(":converter-core"))
    runtimeOnly(libs.h2)
}