package com.hmall.trade.consumer;

import com.hmall.trade.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PayStatusListener {

    private final IOrderService orderService;
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "trade.pay.success", durable = "true"),
            exchange = @Exchange(name = "pay.direct", type = ExchangeTypes.DIRECT, durable = "true"),
            key = "pay.success"
    ))
    public void listenPaySuccess(Long orderId){
        System.out.println("通过消息队列处理订单状态");
        orderService.markOrderPaySuccess(orderId);
    }
}
