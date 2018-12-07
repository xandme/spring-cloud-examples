package com.xandme;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
 * Created by Yhw on 2018/12/7
 */
@FeignClient("eureka-client")//注解来指定这个接口所要调用的服务名称
public interface HelloClient {

    @GetMapping("/hello")
    String consumer();
}
