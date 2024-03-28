//package com.abc.SpringTest.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@Configuration
//public class ThreadPoolConfig {
//
//    @Bean(name = "restApiThreadPool")
//    public ThreadPoolTaskExecutor restApiThreadPool() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(100); // Set the core pool size
//        executor.setMaxPoolSize(200); // Set the maximum pool size
//        executor.setQueueCapacity(100); // Set the queue capacity
//        executor.setThreadNamePrefix("RestApiThread-"); // Set the thread name prefix
//        executor.initialize();
//        return executor;
//    }
//}