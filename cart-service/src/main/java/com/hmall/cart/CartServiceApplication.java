package com.hmall.cart;

import com.hmall.hmapi.client.ItemClient;
import com.hmall.hmapi.config.FeignFallbackConfig;
import com.hmall.hmapi.config.FeignLogConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@MapperScan("com.hmall.cart.mapper")
// 记得添加Feign的相关配置类
// sentinel对feign远程调用异常控制时记得开启feign.sentinel.enable
@EnableFeignClients(value = "com.hmall.hmapi.client", defaultConfiguration = {FeignLogConfig.class, FeignFallbackConfig.class})
public class CartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartServiceApplication.class, args);
    }

}
