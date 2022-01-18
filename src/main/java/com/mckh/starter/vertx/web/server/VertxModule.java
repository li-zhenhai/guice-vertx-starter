package com.mckh.starter.vertx.web.server;

import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class VertxModule extends AbstractModule {
    public static Logger LOG = LoggerFactory.getLogger(VertxModule.class);

    private final VertxOptions options;

    public VertxModule(VertxOptions options) {
        this.options = options;
    }

    @Provides
    @Singleton
    public Vertx vertx() {
        LOG.info("Setting up vert.x with options: {}",options.toJson());

        return Vertx.vertx(options);
    }

    @Provides
    @Singleton
    public Router router(Vertx vertx) {
        LOG.info("Setting up router");

        return Router.router(vertx);

    }

    @Provides
    @Singleton
    @StandardHttpServer
    public HttpServerOptions options() {
        LOG.info("Setting up http server options");
        return new HttpServerOptions()
                .setPort(80);
    }

    // binding annotation: https://www.tutorialspoint.com/guice/guice_binding_annotations.htm
    public
    @BindingAnnotation
    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface StandardHttpServer {
    }
}

