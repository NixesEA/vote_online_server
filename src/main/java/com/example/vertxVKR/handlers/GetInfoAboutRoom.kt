package com.example.vertxVKR.handlers

import com.example.vertxVKR.VertxApplication.Companion.global
import com.google.gson.Gson
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext

class GetInfoAboutRoom: Handler<RoutingContext> {

    override fun handle(event: RoutingContext) {
        event.request().bodyHandler { requestBody ->
            try {
                val req = event.request().getParam("id").toInt()
                println("get room by id:: id = ${req}")
                if (req == null) {
                    endResponse(event, "Some error with ID")
                } else {
                    endResponse(event, Gson().toJson(global[req]))
                }
            } catch (e: Throwable) {
                endResponse(event, "some error")
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