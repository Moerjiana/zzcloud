package com.amay.cont.controller;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.amay.cont.feign.RemoteUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
@AllArgsConstructor
@Slf4j
public class TestController {

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final RemoteUserService remoteUserService;

    private static String resourceName = "sentinel-test1";

    @GetMapping("/init")
    public Object test() {
        return remoteUserService.selectOne(1);
    }

//    @GetMapping("/init")
//    public Object test() {
////        initFlowRules();
//        Entry entry = null;
//        MyUser user = null;
//        try {
//            entry = SphU.entry(this.resourceName);
//            user = remoteUserService.selectOne(1);
//            if (user != null) {
//                throw new IllegalStateException("aaaa");
//            }
//        } catch (BlockException e) {
//            log.info("限流或降级了:{}", e.getMessage());
//            return "限流或降级了";
//        } catch (IllegalStateException e) {
//            Tracer.trace(e);
//            return "参数非法";
//        } finally {
//            if (entry != null) {
//                entry.exit();
//            }
//        }
//        return user;
//    }

    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource(this.resourceName);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }


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
}
