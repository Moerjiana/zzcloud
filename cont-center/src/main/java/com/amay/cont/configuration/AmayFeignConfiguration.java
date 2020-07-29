package com.amay.cont.configuration;


import feign.Logger;
import org.springframework.context.annotation.Bean;

public class AmayFeignConfiguration {
    @Bean
    public Logger.Level level(){
        return Logger.Level.BASIC;
    }
}
