package com.example.VertxDemo.router;

import com.example.VertxDemo.JsonUtils;
import com.example.VertxDemo.dto.Person;
import com.example.VertxDemo.service.PersonService;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PersonRouter extends AbstractRouter {
    @Autowired
    private PersonService personService;
    @Override
    public String getRouterName() {
        return "PERSON ROUTER";
    }

    @Override
    public void initRouter(Router router) {
        router.route("/person").handler(routingContext -> {
            routingContext.request().bodyHandler(bodyHandler -> {
                String body = bodyHandler.toString(); // Convert the Buffer to a String
                Person dto = JsonUtils.parse(body, Person.class);

                Future<Boolean> isSuccess = personService.insertPerson(dto);
                isSuccess.onFailure(fail -> {
                            routingContext.json(Map.of("isSuccess", false));
                })
                        .onSuccess(success -> {
                            routingContext.json(Map.of("isSuccess", success.booleanValue()));
                        });
            });
        });
    }
}
