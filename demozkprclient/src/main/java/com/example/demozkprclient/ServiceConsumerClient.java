package com.example.demozkprclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class ServiceConsumerClient {

    @Autowired
    private TheClient theCLient;

    @FeignClient(name="greetapi")
   interface TheClient{

        @RequestMapping(value = "/greetapi", method = RequestMethod.GET)
        @ResponseBody
        String greet();
    }

    public String greetService(){
        return theCLient.greet();
    }
}
