package com.xandme.client;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
 * Created by Yhw on 2018/12/7
 */
@FeignClient(value = "upload-server",configuration = UploadClient.MultipartSupportConfig.class)//注解来指定这个接口所要调用的服务名称
public interface UploadClient {

    @PostMapping(value = "/uploadFile",consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestParam(value = "file")MultipartFile file);

    @Configuration
    class MultipartSupportConfig{
        @Bean
        public Encoder feignFormEncoder(){
            return new SpringFormEncoder();
        }
    }
}
