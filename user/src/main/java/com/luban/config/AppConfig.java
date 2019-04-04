package com.luban.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 皇甫
 */
@Configuration
public class AppConfig {
    /**
     * 远程方法调用
     * 加LoadBalanced注解 默认使用SpringCloud的负载均衡策略
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 返回负载均衡策略具体的实现类
     * RetryRule服务挂掉一定时间阿内会不访问 剩余的服务使用轮询
     * RoundRobinRule默认是轮询
     * AvailabilityFilteringRule由于连续连接或读取失败，处于断路器跳闸状态
     * BestAvailableRule跳过具有“跳闸”断路器的服务器的规则并选择
     * RandomRule随机
     * WeightedResponseTimeRule使用平均/百分位响应时间*的规则为每个服务器分配动态“权重”，然后以“加权循环”方式使用。
     * ZoneAvoidanceRule返回的“始终为真”谓词
     * 如果要设置不同的服务使用不同的负载均衡策略，则需要将负载均衡器放置到SpringBoot的
     * 扫描范围，在启动类上增加配置即可
     * @return
     */
    /*@Bean
    public IRule iRule(){
        return new RetryRule();
    }*/
    /**
     * 设置端口 访问
     */
    /*@Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(5000);
        return tomcatServletWebServerFactory;
    }*/
}
