package com.hmall.pay;

import com.hmall.hmapi.config.FeignLogConfig;
import com.hmall.hmapi.config.FeignRequestConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.hmall.pay.mapper")
@EnableFeignClients(value = "com.hmall.hmapi.client", defaultConfiguration = {FeignLogConfig.class, FeignRequestConfig.class})
public class PayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayServiceApplication.class, args);
    }

}
