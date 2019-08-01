package com.example.vertxVKR.handlers

import com.example.vertxVKR.VertxApplication.Companion.global
import com.google.gson.Gson
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.util.FileManager
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

    private fun sparqlExec(device:String): HashMap<String,String>? {
        FileManager.get().addLocatorClassLoader(MainHandler::class.java.classLoader)
        val file = FileManager.get().loadModel("C:\\Users\\Anton\\IdeaProjects\\art\\src\\main\\resources\\iot_vkr2.owl")

        val queryStr = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX iot: <http://webprotege.stanford.edu/project/co6WD6WelXsz2DLygYbnb#>\n" +
                "SELECT ?x ?model\n" +
                "WHERE {\n" +
                "?x rdf:type iot:$device.\n" +
                "?x iot:содержит ?model\n" +
                "}"

        val query = QueryFactory.create(queryStr)
        val qexec = QueryExecutionFactory.create(query, file)
        val strBuilder = HashMap<String,String>()
        try {
            val results = qexec.execSelect()
            while (results.hasNext()) {
                val soln = results.nextSolution()
                strBuilder.put(soln.get("model").toString().replace("http://webprotege.stanford.edu/project/co6WD6WelXsz2DLygYbnb#", ""),soln.get("x").toString().replace("http://webprotege.stanford.edu/project/co6WD6WelXsz2DLygYbnb#", ""))
            }

        } catch (e: Throwable) {
            e.printStackTrace()
            return null
        } finally {
            qexec.close()
        }
        return strBuilder
    }
}