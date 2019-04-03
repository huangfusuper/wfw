package com.huengfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 皇甫
 */
@SpringBootApplication
@EnableEurekaClient
public class PowerAppServer {
    public static void main(String[] args) {
        SpringApplication.run(PowerAppServer.class, args);
    }
}
