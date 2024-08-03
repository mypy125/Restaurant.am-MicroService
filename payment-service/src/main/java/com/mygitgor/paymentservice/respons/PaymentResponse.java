package com.mygitgor.paymentservice.respons;

import com.mygitgor.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentResponse extends JpaRepository<Payment, Long> {

}
