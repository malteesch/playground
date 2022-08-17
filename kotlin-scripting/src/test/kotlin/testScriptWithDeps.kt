import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldNotBe
import kotlin.script.experimental.api.ScriptDiagnostic

class ScriptWithDepsTest: FunSpec({
    test("a script with deps should be able to resolve deps and evaluate script") {
        evalCode(
            """@file:Repository("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")

import kotlinx.html.*
import kotlinx.html.stream.*
import kotlinx.html.attributes.*

val addressee = "World"

print(
    createHTML().html {
        body {
            h1 { +"Hello, ${"$"}addressee!" }
        }
    }
)"""
        ).reports.forEach {
            it.severity shouldNotBe ScriptDiagnostic.Severity.ERROR
        }
    }
})
