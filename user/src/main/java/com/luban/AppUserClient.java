package com.luban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import rule.OrderConfigRule;
import rule.PowerConfigRule;

/**
 * @author 皇甫
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient(name="ORDER-CLIENT",configuration= OrderConfigRule.class),
        @RibbonClient(name="POWER-CLIENT",configuration= PowerConfigRule.class)
})
@EnableFeignClients
@EnableHystrix
public class AppUserClient {
    public static void main(String[] args) {
        SpringApplication.run(AppUserClient.class, args);
    }
}
