package com.mygitgor.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long totalAmount;
    private String orderStatus;
    private Date createAt;

    @OneToMany
    private List<OrderItem> items;

    //    private Payment payment;
    private int totalItem;
    private int totalPrice;

}
