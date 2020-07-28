package com.amay.user.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
@AllArgsConstructor
@Slf4j
public class TestController {

    private final DiscoveryClient discoveryClient;

    @GetMapping("/init")
    public Object test(){
        List<String> services = discoveryClient.getServices();
        services.forEach(e->{
            log.info(e);
        });
        log.info("==========");
        return discoveryClient.getInstances(services.get(0));
    }
}
