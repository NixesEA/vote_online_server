package com.example.vertxVKR;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class VertxApp {
    private static Vertx vertx = Vertx.vertx();
    public static Router router = Router.router(vertx);

    public static void main(String[] args) {
                vertx.deployVerticle(new Application());
    }
}
