package io.vertx.example

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
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
    override fun start(startFuture: Future<Void>?) {
        vertx.createHttpServer()
                .requestHandler(router::handle)
                .listen(1081) { result ->
                    run {
                        if (result.succeeded()) {
                            startFuture?.complete()
                        } else {
                            startFuture?.fail(result.cause())
                        }
                    }
                }

    }
}