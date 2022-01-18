package com.mckh.starter.vertx.web.server;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRouterModule extends AbstractModule {
    public static Logger LOG = LoggerFactory.getLogger(TestRouterModule.class);

    @Inject
    public void router(Router router) {
        LOG.info("Setting up router: /test");

        // TODO try to build router using OpenAPI spec file: https://how-to.vertx.io/web-and-openapi-howto/
        router.route("/test").handler((request) -> {
            request.response()
                    .setStatusCode(HttpResponseStatus.OK.code())
                    .putHeader("Content-type", "text/html")
                    .send("Testing web server <b>success</b>!");
        });
    }
}
