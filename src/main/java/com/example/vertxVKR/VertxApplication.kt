package com.example.vertxVKR

import com.example.vertxVKR.handlers.*
import com.example.vertxVKR.models.Response
import com.google.gson.Gson
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future


class VertxApplication : AbstractVerticle() {

    override fun start(startFuture: Future<Void>?) {
        val httpServer = vertx.createHttpServer()
        val router = EntryPoint.router

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


        router.post("/users_sparql")
                .handler(UsersSPARQL())

        router.get("/graph")
                .handler(MainHandler())

        router.get("/all_subclassof")
                .handler(AllSubClass())

        router.get("/all_module")
                .handler(AllModule())

        router.get("/all_module_in_device")
                .handler(AllModuleInDevice())

        router.get("/all_devices_contains_module")
                .handler(AllDeviceContainsModule())

        router.get("/all_mod_mes_param")
                .handler(AllModuleMeasuringParam())
        router.get("/all_dev_mes_param")
                .handler(AllDevicesMeasuringParam())

        router.get("/all_dev_param")
                .handler(AllDevicesParam())


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