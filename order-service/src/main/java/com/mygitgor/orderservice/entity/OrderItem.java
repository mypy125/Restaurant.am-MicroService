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
    private Long orderId;
    private Long foodId;
    private int quantity;
}
