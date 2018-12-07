package com.xandme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yhw on 2018/12/6
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String index() {
        String services = "Services: " + client.getServices();
        System.out.println(services);
        return services;
    }
}
