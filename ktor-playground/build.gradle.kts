plugins {
    // @see https://youtrack.jetbrains.com/issue/KTIJ-19369
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.jvm)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(libs.ktor.server)
    implementation(libs.ktor.server.netty)
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation(libs.kotlinx.coroutines)

}

application {
    mainClass.set("MainKt")
}
