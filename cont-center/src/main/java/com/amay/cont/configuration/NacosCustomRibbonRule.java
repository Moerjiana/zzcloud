package com.amay.cont.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configurable
@Slf4j
public class NacosCustomRibbonRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        //查出当前服务的集群地区
        String clusterName = nacosDiscoveryProperties.getClusterName();
        //查出要调用的所有服务
        BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
        String name = baseLoadBalancer.getName();
        try {
            List<Instance> instances = nacosDiscoveryProperties.namingServiceInstance().selectInstances(name, true);
            List<Instance> sameClusterList = instances.stream().filter(e -> Objects.equals(e.getClusterName(), clusterName)).collect(Collectors.toList());
            List<Instance> overInstanceList;
            //判断是否有相同集群地区的服务,优先调用
            if (CollectionUtils.isEmpty(sameClusterList)) {
                overInstanceList = instances;
                log.warn("发生跨集群的调用, name = {}, clusterName = {}, instances = {}",
                        name,
                        clusterName,
                        instances
                );
            }
            //如果没有调用其他的服务
            else{
                overInstanceList = sameClusterList;
            }

            Instance hostByRandomWeight2 = ExtentBalance.getHostByRandomWeight2(overInstanceList);
            return new NacosServer(hostByRandomWeight2);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ExtentBalance extends Balancer{
    public static Instance getHostByRandomWeight2(List<Instance> hosts) {
        return getHostByRandomWeight(hosts);
    }
}
