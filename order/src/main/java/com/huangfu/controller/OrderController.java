package com.huangfu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 皇甫
 */
@RestController
public class OrderController {
    @RequestMapping("getOrder.do")
    public Object getOrder(){
        Map<String,String> map = new HashMap<>();
        map.put("key", "getOrder");
        return map;
    }
}
