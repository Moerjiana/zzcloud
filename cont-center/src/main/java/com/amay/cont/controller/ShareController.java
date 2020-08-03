package com.amay.cont.controller;

import com.amay.cont.entity.UserMqMsgDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
@AllArgsConstructor
@Slf4j
public class ShareController {

    private final RocketMQTemplate rocketMQTemplate;

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id) {
        rocketMQTemplate.convertAndSend("add-integral",
                UserMqMsgDto.builder()
                        .userId(1)
                        .integral(20)
                        .build());
        log.info("增加积分消息已发送...");
        return "success";
    }
}
