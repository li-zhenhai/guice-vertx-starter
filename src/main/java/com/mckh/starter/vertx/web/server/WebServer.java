package com.mckh.starter.vertx.web.server;

import com.google.inject.Inject;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServer {
    private static Logger LOG = LoggerFactory.getLogger(WebServer.class);

    private final Vertx vertx;
    private final HttpServerOptions httpOptions;
    private final Router router;

    @Inject
    public WebServer(Vertx vertx,
                     @VertxModule.StandardHttpServer HttpServerOptions httpOptions,
                     Router router) {
        this.vertx = vertx;
        this.httpOptions = httpOptions;
        this.router = router;
    }

    public void start() {
        LOG.info("Creating web server with options: {}", httpOptions.toJson());
        var server = vertx.createHttpServer(httpOptions);
        server.requestHandler(router);
        server.listen();
        LOG.info("Web server listening on port {}.", server.actualPort());
    }
}
