package com.xandme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yhw on 2018/12/7
 */
@RestController
public class HelloController {

    @Autowired
    private HelloClient helloClient;

    @GetMapping("/consumer")
    public String consumer() {
        return helloClient.consumer();
    }
}
