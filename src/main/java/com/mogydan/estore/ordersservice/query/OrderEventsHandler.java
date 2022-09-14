package com.mogydan.estore.ordersservice.query;

import com.mogydan.estore.ordersservice.core.data.OrderEntity;
import com.mogydan.estore.ordersservice.core.data.OrdersRepository;
import com.mogydan.estore.ordersservice.core.events.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
public class OrderEventsHandler {
    private final OrdersRepository ordersRepository;

    @EventHandler
    public void on(OrderCreatedEvent orderCreatedEvent) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderCreatedEvent, orderEntity);
        ordersRepository.save(orderEntity);
    }

}
