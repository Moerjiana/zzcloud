package com.amay.user.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

//@RocketMQMessageListener(consumerGroup = "mq-test1", topic = "add-integral")
//@AllArgsConstructor
//@Slf4j
//@Service
//public class IntegralListener implements RocketMQListener<UserMqMsgDto> {
//
//    private final MyUserService myUserService;
//
//    @Override
//    public void onMessage(UserMqMsgDto userMqMsgDto) {
//        MyUser user = myUserService.queryById(userMqMsgDto.getUserId());
//        myUserService.update(MyUser.builder()
//                .userId(user.getUserId())
//                .integral(user.getIntegral() + userMqMsgDto.getIntegral())
//                .build()
//        );
//        log.info("user模块增加积分成功!");
//    }
//}
@Slf4j
@Service
public class IntegralListener{

    @StreamListener(Sink.INPUT)
    @SendTo("temp-output")
    public String receive(String receiveMsg) {
        System.out.println("receive: " + receiveMsg);
        return "handle by SendTo(" + receiveMsg + ")";
    }
}