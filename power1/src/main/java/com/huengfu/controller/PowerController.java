package com.huengfu.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 皇甫
 */
@RestController
public class PowerController {
    @RequestMapping("/getPower.do")
    public Object getPower(){
        Map<String,String> map = new HashMap<>();
        map.put("key1", "getPower1");
        return map;
    }
}
