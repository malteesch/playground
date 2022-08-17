import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

suspend fun main() {
    val scope = CoroutineScope(coroutineContext)
    val server1 = scope.launch {
        embeddedServer(Netty, port = 8080) {
            routing {
                get("/") {
                    call.respondText("hi from 1")
                }
            }
        }.start(wait = true)
    }
    val server2 = scope.launch {
        embeddedServer(Netty, port = 8081) {
            routing {
                get("/") {
                    call.respondText("hi from 2")
                }
            }
        }.start(wait = true)
    }
    listOf(server1, server2).joinAll()
}
