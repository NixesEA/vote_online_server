package com.example.vertxVKR.handlers

import com.example.vertxVKR.VertxApplication.Companion.global
import com.google.gson.Gson
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.util.FileManager
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext

class SaveVoteProgress: Handler<RoutingContext> {

    override fun handle(event: RoutingContext) {
        event.request().bodyHandler { requestBody ->
            try {
                var id = event.request().getParam("id").toInt()
                var vote = event.request().getParam("vote")

                var count = global[id].speakers.get(vote)?.plus(1)!!

                global[id].speakers.put(vote,count)

                println("vote::$vote")
                println("global::${global[id].speakers}")
                if (vote == null) {
                    endResponse(event, "some error")
                } else {
                    endResponse(event, Gson().toJson(RequestBody(status = "ok")))
                }
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