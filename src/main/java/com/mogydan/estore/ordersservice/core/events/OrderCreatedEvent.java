package com.mogydan.estore.ordersservice.core.events;


import com.mogydan.estore.ordersservice.core.model.OrderStatus;
import lombok.Data;

@Data
public class OrderCreatedEvent {
    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    private OrderStatus orderStatus;
}
