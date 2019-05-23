package com.example.vertxVKR.handlers

import com.example.vertxVKR.models.Response
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import com.google.gson.Gson
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import java.util.HashMap
import java.io.FileInputStream


class NestedHandler : Handler<RoutingContext> {

    lateinit var docRef: DocumentReference
    var db:Firestore

    init {
        // Use the application default credentials
        val serviceAccount = FileInputStream("C:\\Users\\Anton\\Downloads\\iot-vkr-9c89f898c306.json")
        val credentials = GoogleCredentials.fromStream(serviceAccount)
        val options = FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setDatabaseUrl("https://iot-vkr.firebaseio.com/")
                .build()

        FirebaseApp.initializeApp(options)

        db = FirestoreClient.getFirestore()
    }

    override fun handle(event: RoutingContext) {
        event.request().bodyHandler { requestBody ->
            try {
                val reqBody = Gson().fromJson(requestBody.toString(), RequestBodySaveData::class.java)

                docRef = db.collection(reqBody.deviceGroup).document(reqBody.deviceName).collection(reqBody.storingTime).document("params")
                docRef.set(reqBody.valueMap as Map<String, Any>)

                handleDefault("200", event)
            } catch (e: Throwable) {
                handleDefault("500", event)
                e.printStackTrace()
            }
        }
    }

    private fun handleDefault(requestStatus: String, event: RoutingContext) {
        val response = Response(requestStatus)
        endResponse(event, response)
    }

    private fun endResponse(event: RoutingContext, responseBody: Response) {
        val response = event.response()
        val jsonResponseBody = Gson().toJson(responseBody)
        response.end(jsonResponseBody)
    }
}

class RequestBodySaveData {
    var deviceGroup: String = ""
    var deviceName: String = ""
    var storingTime: String = ""

    lateinit var valueMap:HashMap<String,String>
}