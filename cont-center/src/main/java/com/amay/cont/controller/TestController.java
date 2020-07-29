package com.amay.cont.controller;

import com.amay.cont.entity.MyUser;
import com.amay.cont.feign.RemoteUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test")
@AllArgsConstructor
@Slf4j
public class TestController {

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final RemoteUserService remoteUserService;

    @GetMapping("/init")
    public Object test(){
//        List<String> services = discoveryClient.getServices();
//        services.forEach(e->{
//            log.info(e);
//        });
//        log.info("==========");
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
//
//        int i = ThreadLocalRandom.current().nextInt(instances.size());
//        MyUser user = restTemplate.getForObject(
//                "http://user-center/myUser/selectOne/{userId}",
//                MyUser.class,
//                1
//        );
        MyUser user = remoteUserService.selectOne(1);
        return user;
    }
}
