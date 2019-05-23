package com.example.vertxVKR.handlers

import com.google.gson.Gson
import com.hp.hpl.jena.query.QueryExecutionFactory
import com.hp.hpl.jena.query.QueryFactory
import com.hp.hpl.jena.util.FileManager
import io.vertx.core.Handler
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.RoutingContext

class MainHandler : Handler<RoutingContext> {


    init {sparqlTest()
    }

    override fun handle(event: RoutingContext) {
        event.request().bodyHandler { requestBody ->
            try {
                handleDefault(requestBody, event)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    private fun handleDefault(requestBody: Buffer, event: RoutingContext) {
        var reqBody = Gson().fromJson(requestBody.toString(), RequestBodyRpc::class.java)

        endResponse(event, reqBody)
    }

    private fun endResponse(event: RoutingContext, reqBody: RequestBodyRpc) {
        val response = event.response()
        val jsonResponseBody = Gson().toJson("AnyString")
        response.end(jsonResponseBody)
    }

    fun sparqlTest(): Boolean {
        FileManager.get().addLocatorClassLoader(MainHandler::class.java.classLoader)
//        val model = FileManager.get().loadModel("C:\\Users\\Anton\\IdeaProjects\\art\\src\\main\\resources\\root-ontology.owl")
        val model = FileManager.get().loadModel("C:\\Users\\Anton\\IdeaProjects\\art\\src\\main\\resources\\ontology_v2.owl")

        val queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                "SELECT ?subject ?predicate ?object\n" +
                "WHERE {?subject rdfs:label ?object} \n" +
                "LIMIT 100"

        val query = QueryFactory.create(queryString)
        val qexec = QueryExecutionFactory.create(query, model)
        try {
            val results = qexec.execSelect()
            while (results.hasNext()) {
                val soln = results.nextSolution()
                val literal = soln.getLiteral("object")
                System.out.println(literal.toString())
            }

        } catch (e: Throwable) {
            return false
        } finally {
            qexec.close()
        }
        return true
    }

}

class RequestBodyRpc {
    var firstName: String = ""
    var lastName: String = ""
}