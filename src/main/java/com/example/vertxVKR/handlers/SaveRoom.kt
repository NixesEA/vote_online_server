package com.example.vertxVKR.handlers

import com.example.vertxVKR.VertxApplication
import com.example.vertxVKR.VertxApplication.Companion.global
import com.google.gson.Gson
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.util.FileManager
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

    private fun sparqlExec(queryStr: String): ArrayList<String>? {
        FileManager.get().addLocatorClassLoader(MainHandler::class.java.classLoader)
        val file = FileManager.get().loadModel("C:\\Users\\Anton\\IdeaProjects\\art\\src\\main\\resources\\iot_vkr2.owl")

        val query = QueryFactory.create(queryStr)
        val qexec = QueryExecutionFactory.create(query, file)
        val strBuilder = ArrayList<String>()
        try {
            val results = qexec.execSelect()
            while (results.hasNext()) {
                val soln = results.nextSolution()
                strBuilder.add(soln.get("x").toString().replace("http://webprotege.stanford.edu/project/co6WD6WelXsz2DLygYbnb#", ""))
            }

        } catch (e: Throwable) {
            return null
        } finally {
            qexec.close()
        }
        return strBuilder
    }
}

data class RequestBody(
        var status: String = ""
)