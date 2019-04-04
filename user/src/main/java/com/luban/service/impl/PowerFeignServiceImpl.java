package com.luban.service.impl;

import com.luban.service.PowerFeignService;
import org.springframework.stereotype.Component;

/**
 * 注解必须加 一定要交给Spring管理
 * @author 皇甫
 */
@Component
public class PowerFeignServiceImpl implements PowerFeignService {
    @Override
    public Object getPower() {
        return "方法调用失败，哈哈哈哈哈哈，人间不值得";
    }
}
