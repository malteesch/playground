plugins {
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
}

val runTestScript by tasks.registering(JavaExec::class) {
    classpath = configurations["runtimeClasspath"]
    mainClass.set("HostKt")
    args = listOf(file("${projectDir}/html.scriptWithDeps.kts").absolutePath)
}
