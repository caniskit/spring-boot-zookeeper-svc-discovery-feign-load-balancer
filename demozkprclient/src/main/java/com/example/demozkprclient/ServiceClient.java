package com.example.demozkprclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class ServiceClient {

    @Autowired
    ServiceConsumerClient consumerClient;



    @GetMapping
    public String getServices(){

        return consumerClient.greetService();



    }



}
