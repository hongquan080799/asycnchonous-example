package com.example.VertxDemo;

import com.example.VertxDemo.config.MainVerticle;
import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VertxDemoApplication {
	@Autowired
	private Vertx vertx;
	@Autowired
	private MainVerticle mainVerticle;

	public static void main(String[] args) {
		SpringApplication.run(VertxDemoApplication.class, args);
	}

	@PostConstruct
	public void deployVerticle() {
		int numInstances = 10; // Specify the desired number of instances
		for (int i = 0; i < numInstances; i++) {
			vertx.deployVerticle(mainVerticle);
		}
	}

}
