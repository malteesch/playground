plugins {
    // @see https://youtrack.jetbrains.com/issue/KTIJ-19369
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(project(":kotlin-scripting:scripting-host"))
    testImplementation(testLibs.kotest.framework)
    testImplementation(testLibs.kotest.assertions)
    testImplementation(libs.kotlin.scripting)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
