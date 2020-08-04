package com.amay.cont;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.amay.cont.dao")
@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding(Source.class)
public class ContApplication {

    public static final String TEMP_INPUT = "temp-output";

    @Bean(ContApplication.TEMP_INPUT)
    public MessageChannel tempChannel() {
        return new DirectChannel();
    }

    public static void main(String[] args) {
        SpringApplication.run(ContApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
