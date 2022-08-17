dependencies {
    implementation(libs.kotlin.scripting)
    implementation(libs.kotlin.scripting.jvm)
    implementation(libs.kotlin.scripting.jvm.host)
    implementation(project(":kotlin-scripting:script-definition")) // the script definition module
}

val runTestScript by tasks.registering(JavaExec::class) {
    classpath = configurations["runtimeClasspath"] + files("${buildDir}/classes/kotlin/main")
    mainClass.set("HostKt")
    args = listOf(file("${projectDir}/../html.scriptWithDeps.kts").absolutePath)
}
