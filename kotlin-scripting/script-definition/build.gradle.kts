dependencies {
    implementation(libs.kotlin.scripting)
    implementation(libs.kotlin.scripting.jvm)
    implementation(libs.kotlin.scripting.dependencies)
    implementation(libs.kotlin.scripting.dependencies.maven)
    // coroutines dependency is required for this particular definition
    implementation(libs.kotlinx.coroutines)
    runtimeOnly("org.slf4j:slf4j-nop:1.7.36")
}

