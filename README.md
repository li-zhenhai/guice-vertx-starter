# A starter project with Guice + Vert.x

See `com.mckh.starter.vertx.web.server` package for the starter project.

It includes:
1. Guice for dependency injection in `WebServerApplication`
2. Vert.x for HTTP server and async event loop in `WebServer`
3. Provide dependencies, e.g. Vertx, Router, in Guice AbstractModule `VertxModule`
4. Define HTTP endpoint handler for `GET /test` in Guice AbstractModule `TestRouterModule`

More HTTP endpoints can be added by adding more AbstractModule like `TestRouterModule`
and include it in the main application in `WebServerApplication`.
