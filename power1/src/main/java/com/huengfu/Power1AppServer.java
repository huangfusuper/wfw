package com.huengfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 皇甫
 */
@SpringBootApplication
@EnableEurekaClient
public class Power1AppServer {
    public static void main(String[] args) {
        SpringApplication.run(Power1AppServer.class, args);
    }
}
