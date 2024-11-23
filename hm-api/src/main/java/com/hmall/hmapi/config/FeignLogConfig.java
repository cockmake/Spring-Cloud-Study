package com.hmall.hmapi.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

// 不添加配置注解是因为不是所有的Client都引用这一个日志输出级别
// 当所有Client都用这个输出级别的时候可以添加@Configuration也可以使用defaultConfiguration

public class FeignLogConfig {
    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
