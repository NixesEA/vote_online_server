package com.example.vertxVKR.handlers

import com.google.gson.Gson
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.util.FileManager
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext


class UsersSPARQL : Handler<RoutingContext> {

    override fun handle(event: RoutingContext) {
        event.request().bodyHandler { requestBody ->
            try {
                val reqBody = Gson().fromJson(requestBody.toString(), RequestBodySPARQL::class.java)

                val req = sparqlExec(reqBody.sparql)
                if (req == null) {
                    endResponse(event, "some error")
                } else {
                    endResponse(event,Gson().toJson(req))
                }
            } catch (e: Throwable) {
                endResponse(event, "some error")
                e.printStackTrace()
            }
        }
    }

    private fun endResponse(event: RoutingContext, responseBody: String) {
        val response = event.response()
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

class RequestBodySPARQL {
    var sparql: String = ""
}