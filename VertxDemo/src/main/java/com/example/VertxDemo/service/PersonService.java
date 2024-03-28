package com.example.VertxDemo.service;

import com.example.VertxDemo.dto.Person;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonService {
    @Autowired
    private Pool pool;
    public Future<Boolean> insertPerson(Person person) {
        Promise<Boolean> personPromise = Promise.promise();
        pool.withConnection(connection ->
                connection
                        .preparedQuery("INSERT INTO user_info (name,address, email, description, gender, updated_by, created_by) VALUES (?, ?, ?, ?, ?, ?, ?)")
                        .execute(Tuple.of(person.getName(), person.getAddress(), person.getEmail(), person.getDescription(), person.getGender(), person.getUpdatedBy(), person.getCreatedBy()))
//                        .compose(res -> connection
//                                // Do something with rows
//                                .query("SELECT LAST_INSERT_ID() AS id")
//                                .execute()
//                                .map(rows -> rows.iterator().next().getLong(0)))
        ).onSuccess(index -> {
            personPromise.complete(true);
//            System.out.println("Insert persons, last index:  " + index);


        }).onFailure(res -> {
            System.out.println(res);
            personPromise.fail(res.getCause());
        });

        return personPromise.future();
    }
}
