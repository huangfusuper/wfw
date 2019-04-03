package com.luban.controller;

import com.luban.utils.R;
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
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/getUser")
    public R getUser(){
        Map<String,String> map = new HashMap<>();
        map.put("key", "用户数据");
        return R.success("返回成功", map);
    }

    @RequestMapping("/getPower")
    public R getPower(){
        Map<String,String> map = new HashMap<>();
        map.put("key", "用户数据");
        return R.success("返回成功", restTemplate.getForObject(POWER+"/getPower.do", Object.class));
    }
}
