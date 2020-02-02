package example.flowable

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("controller.hangs.flowable")
                .mainClass(Application.javaClass)
                .start()
    }
}