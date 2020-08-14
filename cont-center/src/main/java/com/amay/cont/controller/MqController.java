package com.amay.cont.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("testMq")
@RestController
public class MqController {

    @GetMapping("initProducer")
    public Object initProducer() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("test-producer-group");
//        defaultMQProducer.setNamesrvAddr("127.0.0.1:9876");
        defaultMQProducer.start();

        for (int i = 0; i < 5; i++) {
            defaultMQProducer.send(new Message("topic-test1",("没nameservAddr消息:"+i).getBytes()));
        }

        defaultMQProducer.shutdown();
        return "success";
    }
}
