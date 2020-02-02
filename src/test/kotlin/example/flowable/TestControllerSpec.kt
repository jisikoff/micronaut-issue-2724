package example.flowable

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
        "should return something - not hang!" {
            val rsp: String = client.toBlocking().retrieve("/test/hangs")
            rsp shouldBe "onetwothree"
        }
    }
}