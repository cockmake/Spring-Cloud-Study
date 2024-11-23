package com.hmall.gateway.config;

import cn.hutool.json.JSONUtil;
import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

@Slf4j
@Component
@RequiredArgsConstructor
public class DynamicRouterLoader {

    // 在nacos-config包下
    private final NacosConfigManager nacosConfigManager;
    private final RouteDefinitionWriter routeDefinitionWriter;
    private final Set<String> routeIds = new HashSet<>();

    @PostConstruct
    public void initRouteConfigListener() throws NacosException {
        String dataId = "gateway-routes.json";
        String group = "DEFAULT_GROUP";
        long timeout = 5000;
        String routeInfo = nacosConfigManager.getConfigService().getConfigAndSignListener(dataId, group, timeout, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                // 路由配置文件发生变化
                updateRoutes(s);
            }
        });
        updateRoutes(routeInfo);
    }

    public void updateRoutes(String routeInfo) {
        System.out.println("routeInfo: " + routeInfo);
        for (String routeId : routeIds) {
            routeDefinitionWriter.delete(Mono.just(routeId)).subscribe();
        }
        // 清空routeIds
        routeIds.clear();
        List<RouteDefinition> routeDefinitions = JSONUtil.toList(routeInfo, RouteDefinition.class);
        for (RouteDefinition routeDefinition : routeDefinitions) {
            // 更新路由表
            // 注意subscribe的调用
            routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
            // 加入routeIds
            routeIds.add(routeDefinition.getId());
        }
    }
}
