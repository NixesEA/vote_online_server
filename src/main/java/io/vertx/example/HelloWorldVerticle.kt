package io.vertx.example

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpServerRequest
import io.vertx.ext.web.Router

class HelloWorldVerticle : AbstractVerticle() {

    private val router = Router.router(vertx).apply {
        /**
         * Welcome handler.
         */
        get("/").handler { ctx ->
            ctx.response().end("Welcome in MainVerticle!")
        }

        get("/check").handler { ctx ->
            ctx.response().end("Welcome in check!")
        }
    }

    @Throws(Exception::class)
    override fun start() {
        vertx.createHttpServer()
                .requestHandler { router.accept(it) }
                .listen(
                        Integer.getInteger("http.port"), System.getProperty("http.address", "0.0.0.0"))

    }
}