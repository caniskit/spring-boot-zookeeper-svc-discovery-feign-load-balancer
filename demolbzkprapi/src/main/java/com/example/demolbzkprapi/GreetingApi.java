package com.example.demolbzkprapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/greetapi")
public class GreetingApi {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

    @Value("${server.port}")
    private int serverPort;
    @GetMapping
    public String home() {
        String message = "Hello World from Greeting Microservice located at %s,";
        try {
            String address = InetAddress.getLocalHost().getHostAddress()+"port: "+serverPort ;
            message = String.format(message, address);
            LocalDateTime now = LocalDateTime.now();

            message = message + "Api Server time: "+ dtf.format(now);
        } catch (UnknownHostException e) {
            message = String.format(message, "Unknown Host");
        }

        return message;

    }

}
