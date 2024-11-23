package com.hmall.hmapi.client;

import com.hmall.hmapi.client.fallback.ItemClientFallbackFactory;
import com.hmall.hmapi.dto.ItemDTO;
import com.hmall.hmapi.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

// 可以在这配置局部日志
@FeignClient(value = "item-service", path = "/items", fallbackFactory = ItemClientFallbackFactory.class)
public interface ItemClient {
    @GetMapping
    List<ItemDTO> queryItemByIds(@RequestParam("ids")Collection<Long> ids);

    @PutMapping("/stock/deduct")
    void deductStock(@RequestBody List<OrderDetailDTO> items);
}
