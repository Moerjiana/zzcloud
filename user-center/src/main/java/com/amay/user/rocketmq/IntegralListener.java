package com.amay.user.rocketmq;

import com.amay.user.entity.MyUser;
import com.amay.user.entity.UserMqMsgDto;
import com.amay.user.service.MyUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@RocketMQMessageListener(consumerGroup = "mq-test1", topic = "add-integral")
@AllArgsConstructor
@Slf4j
@Service
public class IntegralListener implements RocketMQListener<UserMqMsgDto> {

    private final MyUserService myUserService;

    @Override
    public void onMessage(UserMqMsgDto userMqMsgDto) {
        MyUser user = myUserService.queryById(userMqMsgDto.getUserId());
        myUserService.update(MyUser.builder()
                .userId(user.getUserId())
                .integral(user.getIntegral() + userMqMsgDto.getIntegral())
                .build()
        );
        log.info("user模块增加积分成功!");
    }
}
