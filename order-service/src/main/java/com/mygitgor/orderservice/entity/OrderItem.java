package com.mygitgor.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderItems")
public class OrderItem extends BaseEntity<Long>{
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String name;
    private Double price;
    private Integer quantity;

    public Double getTotalPrice() {
        return price * quantity;
    }
}
