package com.luban.controller;

import com.luban.service.PowerFeignService;
import com.luban.utils.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 自己搭建的微服务弊端
 *
 *
 * @author 皇甫
 */
@RestController
public class AppUserController {
    private final String POWER = "http://POWER-CLIENT";
    private final String ORDER = "http://ORDER-CLIENT";

    /**
     * 注入Feign接口
     */
    @Autowired
    private PowerFeignService powerFeignService;

    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/getUser")
    public R getUser(){
        Map<String,String> map = new HashMap<>();
        map.put("key", "用户数据");
        return R.success("返回成功", map);
    }

    /**
     * 若此时需要给这个服务做降级 需要加注解HystrixCommand
     * 内有参数 为降级的方法名称
     * 这里我使用配置文件进行一次配置 首先制定一个线程池的key 在yml配置文件里面我已经做了配置 注释掉的部分 这里我主要使用注解的方式
     * 然后使用注解的方式进行一次配置 threadPoolKey指定线程的key threadPoolProperties：配置线程池的属性
     * 这里如果又连续的五个请求全部访问了我的这个方法 我就会将剩余的请求转接到降级方法里面 这就是限流
     *
     * 模拟 休眠10s  页面刷新的情况下模拟多线程的方式
     * TODO 未完待续 有更好的方法 暂时卖个关子
     * @return
     */
    @RequestMapping("/getPowerFeign")
    @HystrixCommand(threadPoolKey = "power",threadPoolProperties = {@HystrixProperty(name = "coreSize",value = "5")})
    public R getPowerFeign(){
        Map<String,String> map = new HashMap<>();
        map.put("key", "商品数据");
        return R.success("OJBKFeign", powerFeignService.getPower());
    }

    /**
     * Feign这个方式不支持超时退出，这里暂时使用restTemplate调用，在YML里面需要配置
     * 这里我使用配置文件进行一次配置 首先制定一个线程池的key 在yml配置文件里面我已经做了配置 注释掉的部分 这里我主要使用注解的方式
     * 然后使用注解的方式进行一次配置 threadPoolKey指定线程的key threadPoolProperties：配置线程池的属性
     * 这里如果又连续的五个请求全部访问了我的这个方法 我就会将剩余的请求转接到降级方法里面 这就是限流
     * 模拟 休眠10s  页面刷新的情况下模拟多线程的方式
     * @return
     */
    @HystrixCommand(fallbackMethod = "getPowerFeignFullBack",threadPoolKey = "power1",
            threadPoolProperties = {@HystrixProperty(name = "coreSize",value = "3")})
    @RequestMapping("/getPower")
    public R getPower(){
        System.out.println("-------------------");
        Map<String,String> map = new HashMap<>();
        map.put("key", "商品数据");
        return R.success("返回成功", restTemplate.getForObject(POWER+"/getPower.do", Object.class));
    }

    @RequestMapping("/getOrder")
    public R getOrder(){
        Map<String,String> map = new HashMap<>();
        map.put("key", "订单数据");
        return R.success("返回成功", restTemplate.getForObject(ORDER+"/getOrder.do", Object.class));
    }

    /**
     * 降级方法 方法名称为上方定义的 注意返回值要与主体方法相同
     * TODO 未完待续 有替代
     * @return
     */
    public R getPowerFeignFullBack(){
        return R.error("我只能说是失败了");
    }
}
