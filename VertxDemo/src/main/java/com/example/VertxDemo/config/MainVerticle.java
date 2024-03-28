package com.example.VertxDemo.config;

import com.example.VertxDemo.router.AbstractRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainVerticle extends AbstractVerticle {
    @Autowired
    private List<AbstractRouter> routers;
    @Override
    public void start() {
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        routers.forEach(item -> item.initRouter(router));

        server.requestHandler(router)
                .requestHandler(router)
                .listen(8081, done -> {
                    if(done.succeeded()) {
                        System.out.println("start server on port 8081 successfully");
                    } else {
                        System.out.println(done.cause().getMessage());;
                    }
                });
    }
}
