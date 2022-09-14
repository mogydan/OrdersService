package com.mogydan.estore.ordersservice.core.data;

import com.mogydan.estore.ordersservice.core.model.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column(unique = true)
    public String orderId;

    private String productId;
    private String userId;
    private int quantity;
    private String addressId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
