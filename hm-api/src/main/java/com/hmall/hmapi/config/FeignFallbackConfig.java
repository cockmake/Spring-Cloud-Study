package com.hmall.hmapi.config;

import com.hmall.hmapi.client.fallback.ItemClientFallbackFactory;
import org.springframework.context.annotation.Bean;

public class FeignFallbackConfig {
    @Bean
    public ItemClientFallbackFactory itemClientFallbackFactory() {
        return new ItemClientFallbackFactory();
    }
}
