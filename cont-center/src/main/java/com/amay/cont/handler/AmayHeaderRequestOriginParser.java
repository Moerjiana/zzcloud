package com.amay.cont.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;

import javax.servlet.http.HttpServletRequest;

public class AmayHeaderRequestOriginParser implements RequestOriginParser {

    String heardString = "origin";

    @Override
    public String parseOrigin(HttpServletRequest request) {
        request.getParameter("");
        return null;
    }
}
