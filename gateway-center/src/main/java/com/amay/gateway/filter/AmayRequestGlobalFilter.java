package com.amay.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;

@Component
@Slf4j
public class AmayRequestGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        // 2. 重写StripPrefix //这步到底是干嘛用的？
        addOriginalRequestUrl(exchange, request.getURI());

        String rawPath = request.getURI().getRawPath();
        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(rawPath, "/"))
                .skip(1L).collect(Collectors.joining("/"));
        ServerHttpRequest newRequest = request.mutate()
                .path(newPath)
                .build();
        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
        return chain.filter(exchange.mutate().request(newRequest).build());
    }

    @Override
    public int getOrder() {
        return -1000;
    }
}
