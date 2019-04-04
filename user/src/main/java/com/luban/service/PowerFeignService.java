package com.luban.service;

import com.luban.service.impl.PowerFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 接口Feign 注解里面是服务名称
 * 声明和api方法一样的方法
 * RequestMapping声明远程访问路径
 *
 * 这种方式可以向Server一样注入 简化开发 推荐使用feign
 * fallback实现类的方法 然后实现类实现的方法是降级方法
 * @author 皇甫
 */
@FeignClient(value = "POWER-CLIENT",fallback = PowerFeignServiceImpl.class)
public interface PowerFeignService {
    /**
     * Power调用
     * @return 返回值类型需要和调用的相同
     */
    @RequestMapping("getPower.do")
    public Object getPower();

}
