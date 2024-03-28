package com.example.VertxDemo.config;

import io.vertx.core.Vertx;
import io.vertx.mysqlclient.MySQLBuilder;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.SqlClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Autowired
    private Vertx vertx;
    @Bean
    public Pool sqlClient() {
        MySQLConnectOptions connectOptions = new MySQLConnectOptions()
                .setPort(3306)
                .setHost("localhost")
                .setDatabase("aavn")
                .setUser("root")
                .setPassword("12345678");

        PoolOptions poolOptions = new PoolOptions()
                .setMaxSize(10);


        Pool pool = MySQLBuilder.pool()
                .with(poolOptions)
                .connectingTo(connectOptions)
                .using(vertx)
                .build();

        pool.getConnection(done -> {
            if(done.succeeded()) {
                System.out.println("Connect DB success");
            } else {
                System.out.println("Connect DB failed");
            }
        });

        return pool;
    }

}
