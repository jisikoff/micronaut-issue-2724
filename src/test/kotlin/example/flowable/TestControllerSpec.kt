package example.flowable

import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import javax.inject.Inject


@MicronautTest
class TestControllerSpec: StringSpec() {

    @Inject
    lateinit var server: EmbeddedServer

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient


    init {
        "@blocking annotated controllers should return string indicating the thread is on the io pool not the event pool" {
            val rsp: String = client.toBlocking().retrieve("/test/reactiveblocking")
            rsp shouldContain "pool-"
        }
    }
}