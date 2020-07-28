package com.amay.cont.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@Configurable
@RibbonClients(defaultConfiguration = NacosCustomRibbonRule.class)  //全局ribbon默认配置
public class AmayRibbonConfigurable {
}
