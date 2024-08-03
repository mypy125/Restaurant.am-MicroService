package com.mygitgor.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity<Long>{
    private Long userId;
    private LocalDate createAt;
    private Status status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Double getTotalAmount() {
        return items.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }
}
