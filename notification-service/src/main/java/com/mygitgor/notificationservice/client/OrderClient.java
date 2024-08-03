package com.mygitgor.notificationservice.client;

import com.mygitgor.notificationservice.dto.OrderDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8080/api/orders")
public interface OrderClient {
    @GetMapping("/{id}")
    OrderDetails getOrderById(@PathVariable("id") Long id);
}
