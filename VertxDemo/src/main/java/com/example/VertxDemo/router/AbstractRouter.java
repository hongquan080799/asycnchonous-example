package com.example.VertxDemo.router;

import io.vertx.ext.web.Router;

public abstract class AbstractRouter {
    public abstract String getRouterName();
    public abstract void initRouter(Router router);
}
