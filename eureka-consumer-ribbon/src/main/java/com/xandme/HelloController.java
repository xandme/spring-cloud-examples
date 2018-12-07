package com.xandme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Yhw on 2018/12/6
 */
@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer(){
        return restTemplate.getForObject("http://eureka-client/hello", String.class);
    }
}
