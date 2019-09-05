package com.example.vertxVKR;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class EntryPoint {
    private static Vertx vertx = Vertx.vertx();
    public static Router router = Router.router(vertx);

    public static void main(String[] args) {
                vertx.deployVerticle(new VertxApplication());

    }
}
