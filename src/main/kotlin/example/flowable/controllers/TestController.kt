package example.flowable.controllers

import io.micronaut.core.annotation.Blocking
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single

@Controller("/test")
open class TestController() {

    @Get("/reactiveblocking")
    @Blocking
    open fun reactiveBlocking(): Single<String> {
        return Single.fromCallable({ -> "thread: ${Thread.currentThread().name}" })
    }
}