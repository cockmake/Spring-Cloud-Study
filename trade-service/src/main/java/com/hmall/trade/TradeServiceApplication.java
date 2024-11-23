package com.hmall.trade;

import com.hmall.hmapi.config.FeignLogConfig;
import com.hmall.hmapi.config.FeignRequestConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.hmall.trade.mapper")
@EnableFeignClients(basePackages = "com.hmall.hmapi.client", defaultConfiguration = {FeignLogConfig.class, FeignRequestConfig.class})
public class TradeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeServiceApplication.class, args);
    }

}
