rootProject.name = "playground"
include("kotlin-scripting")
include("kotlin-scripting:script-definition")
include("kotlin-scripting:scripting-host")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val kotlin = version("kotlin", "1.7.10")
            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").versionRef(kotlin)

            library("kotlin-scripting", "org.jetbrains.kotlin", "kotlin-scripting-common").versionRef(kotlin)
            library("kotlin-scripting-jvm", "org.jetbrains.kotlin", "kotlin-scripting-jvm").versionRef(kotlin)
            library("kotlin-scripting-jvm-host", "org.jetbrains.kotlin", "kotlin-scripting-jvm-host").versionRef(kotlin)
            library("kotlin-scripting-dependencies", "org.jetbrains.kotlin", "kotlin-scripting-dependencies").versionRef(kotlin)
            library("kotlin-scripting-dependencies-maven", "org.jetbrains.kotlin", "kotlin-scripting-dependencies-maven").versionRef(kotlin)
            library("kotlinx-coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version("1.6.4")
        }

        create("testLibs") {
            val kotest = version("kotest", "5.4.1")
            library("kotest-framework", "io.kotest", "kotest-runner-junit5").versionRef(kotest)
            library("kotest-assertions", "io.kotest", "kotest-runner-junit5").versionRef(kotest)
        }
    }
}
