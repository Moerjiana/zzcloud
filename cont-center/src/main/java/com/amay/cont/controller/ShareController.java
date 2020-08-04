package com.amay.cont.controller;

import com.amay.cont.entity.MyUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
@Slf4j
public class ShareController {

    @Autowired
    private Source source;

//    @Autowired
//    @Qualifier(Source.OUTPUT)
//    private MessageChannel messageChannel;

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id) {

        boolean send = this.source.output().send(MessageBuilder.withPayload(MyUser.builder().userId(id).build()).build());
//        boolean send = this.messageChannel.send(MessageBuilder.withPayload(MyUser.builder().userId(id).build()).build());
        log.info("发送状态:{}",send);
        return String.valueOf(send);
    }
//    private final RocketMQTemplate rocketMQTemplate;
//
//    @GetMapping("/{id}")
//    public String findById(@PathVariable Integer id) {
//        rocketMQTemplate.convertAndSend("add-integral",
//                UserMqMsgDto.builder()
//                        .userId(1)
//                        .integral(20)
//                        .build());
//        log.info("增加积分消息已发送...");
//        return "success";
//    }
}
