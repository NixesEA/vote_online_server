package com.example.vertxVKR

import com.example.vertxVKR.handlers.MainHandler
import com.example.vertxVKR.handlers.NestedHandler
import com.example.vertxVKR.models.Response
import com.google.gson.Gson
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future


class Application : AbstractVerticle() {

    override fun start(startFuture: Future<Void>?) {
        val httpServer = vertx.createHttpServer()
        val router = VertxApp.router

        httpServer
                .requestHandler(router::accept)
                .listen(1080) { result ->
                    run {
                        if (result.succeeded()) {
                            startFuture?.complete()
                        } else {
                            startFuture?.fail(result.cause())
                        }
                    }
                }


        router.post("/saveData")
                .handler(NestedHandler())

        router.get("/graph")
                .handler(MainHandler())

        router.get("/check")
                .handler { routingContext ->
                    val response = routingContext.response()
                    val responseBody = Response("200")
                    val jsonResponseBody = Gson().toJson(responseBody)
                    response.end(jsonResponseBody)
                }

    }

    data class ResponseObj(var name: String = "ResponseObj")
}