package com.mygitgor.paymentservice.service.impl;

import com.mygitgor.orderservice.client.NotificationClient;
import com.mygitgor.paymentservice.entity.Order;
import com.mygitgor.paymentservice.entity.Payment;
import com.mygitgor.paymentservice.repository.PaymentRepository;
import com.mygitgor.paymentservice.respons.PaymentResponse;
import com.mygitgor.paymentservice.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final NotificationClient notificationClient;

    public PaymentServiceImpl(PaymentRepository paymentRepository, NotificationClient notificationClient) {
        this.paymentRepository = paymentRepository;
        this.notificationClient = notificationClient;
    }

    @Transactional
    public Payment processPayment(Payment payment) {
        Payment createdPayment = paymentRepository.save(payment);
        sendPaymentNotification(createdPayment);
        return createdPayment;
    }

    private void sendPaymentNotification(Payment payment) {
        NotificationDetails notificationDetails = new NotificationDetails(
                payment.getUserId(),
                "Your payment of " + payment.getAmount() + " has been processed.",
                "Pending",
                LocalDateTime.now()
        );
        notificationClient.createNotification(notificationDetails);
    }
}
