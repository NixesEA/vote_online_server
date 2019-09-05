package com.example.vertxVKR.handlers

import com.example.vertxVKR.VertxApplication
import com.example.vertxVKR.VertxApplication.Companion.global
import com.google.gson.Gson
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext


class SaveRoom : Handler<RoutingContext> {

    override fun handle(event: RoutingContext) {
        event.request().bodyHandler { requestBody ->
            try {
                val reqBody = Gson().fromJson(requestBody.toString(), VertxApplication.RawRoom::class.java)

                global[reqBody.id].id = reqBody.id
                for (unit: String in reqBody.speakers) {
                    global[reqBody.id].speakers.put(unit, 0)
                }

                println("save room:: id = ${global[reqBody.id].id}, speakers = ${global[reqBody.id].speakers}")
                endResponse(event, Gson().toJson(RequestBody(status = "ok")))
            } catch (e: Throwable) {
                endResponse(event, Gson().toJson(RequestBody(status = "some error")))
                e.printStackTrace()
            }
        }
    }

    private fun endResponse(event: RoutingContext, responseBody: String) {
        val response = event.response()
        response.putHeader("content-type", "application/json; charset=utf-8")
        response.end(responseBody)
    }

}

data class RequestBody(
        var status: String = ""
)