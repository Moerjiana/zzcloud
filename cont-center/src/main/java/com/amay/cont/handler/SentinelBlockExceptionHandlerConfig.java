package com.amay.cont.handler;

import com.alibaba.csp.sentinel.slots.block.AbstractRule;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(0)
@Slf4j
public class SentinelBlockExceptionHandlerConfig {
    /**
     * 捕获BlockException异常，自定义返回信息
     * @param e
     * @return
     */
    @ExceptionHandler(BlockException.class)
    @ResponseBody
    public String sentinelBlockHandler(BlockException e) {
        AbstractRule rule = e.getRule();
        log.info("Blocked by Sentinel: {}", rule.toString());
        log.info("sentinel 降级/流控 资源名称{}",e.getMessage());
        return "降级/流控";
    }
}
