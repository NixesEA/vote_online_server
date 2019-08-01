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

//        router.get("/graph")
//                .handler(MainHandler())
//
//        router.get("/all_subclassof")
//                .handler(AllSubClass())
//
//        router.get("/all_modules")//check
//                .handler(AllModule())
//
//        router.get("/all_modules_in_device")
//                .handler(GetInfoAboutRoom())
//        router.get("/all_devices_containing_module")
//                .handler(AllDeviceContainsModule())
//
//        router.get("/all_modules_measuring_param")
//                .handler(AllModuleMeasuringParam())
//        router.get("/all_devices_measuring_param")//check
//                .handler(AllDevicesMeasuringParam())
//
//        router.get("/all_dev_param")//check
//                .handler(SaveVoteProgress())
//
//
        router.get("/check")
                .handler { routingContext ->
                    val response = routingContext.response()
                    val responseBody = Response("200")
                    val jsonResponseBody = Gson().toJson(responseBody)
                    response.end(jsonResponseBody)
                }


        router.post("/post_room")
                .handler(SaveRoom())

        router.get("/vote_room")
                .handler(GetInfoAboutRoom())

        router.get("/post_vote")
                .handler(SaveVoteProgress())

        router.get("/getNewId")
                .handler { routingContext ->
                    val response = routingContext.response()
                    val id = ResponseObj(id = global.size)
                    global.add(Room(id = global.size))
                    println("create new room:: id = $id")

                    val jsonResponseBody = Gson().toJson(id)
                    response.end(jsonResponseBody)
                }
    }

    companion object {
        var global = ArrayList<Room>()
    }

    data class RawRoom(var id: Int = 0, var name: String = "Default name", var speakers: List<String> = ArrayList<String>())
    data class Room(var id: Int = 0, var name: String = "Default name", var speakers: HashMap<String, Int> = HashMap())
    data class ResponseObj(var id: Int = 0)
}