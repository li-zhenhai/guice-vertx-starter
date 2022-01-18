package com.mckh.starter.vertx.web.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;

public class WebServerApplication {
    private Vertx vertx;
    private HttpServerOptions options;
    private Router router;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(
                new VertxModule(new VertxOptions())
        );
        injector.getInstance(TestRouterModule.class);
        injector.getInstance(WebServer.class).start();
    }

}
