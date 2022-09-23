package com.mogydan.estore.ordersservice.query;

import com.mogydan.estore.ordersservice.core.data.OrderEntity;
import com.mogydan.estore.ordersservice.core.data.OrdersRepository;
import com.mogydan.estore.ordersservice.core.events.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@ProcessingGroup("order-group")
public class OrderEventsHandler implements Serializable {

    private final OrdersRepository ordersRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(event, orderEntity);

        this.ordersRepository.save(orderEntity);
    }

}
