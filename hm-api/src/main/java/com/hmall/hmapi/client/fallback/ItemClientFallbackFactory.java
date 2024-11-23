package com.hmall.hmapi.client.fallback;

import com.hmall.common.utils.CollUtils;
import com.hmall.hmapi.client.ItemClient;
import com.hmall.hmapi.dto.ItemDTO;
import com.hmall.hmapi.dto.OrderDetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collection;
import java.util.List;


public class ItemClientFallbackFactory implements FallbackFactory<ItemClient> {
    private static final Logger log = LoggerFactory.getLogger(ItemClientFallbackFactory.class);

    @Override
    public ItemClient create(Throwable cause) {
        return new ItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
                log.error("查询商品失败", cause);
                return CollUtils.emptyList();
            }

            @Override
            public void deductStock(List<OrderDetailDTO> items) {
                log.error("扣减库存失败", cause);
            }
        };
    }
}
