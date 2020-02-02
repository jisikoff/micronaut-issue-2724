package example.flowable.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Flowable

@Controller("/test")
open class TestController() {

    @Get(value = "/hangs")
    open fun download(): HttpResponse<Flowable<String>> {
        val flowable = Flowable.just("one", "two", "three")
        return HttpResponse.ok(flowable).contentType("bad") //if you put the slash in like bad/bad this works fine
    }
}