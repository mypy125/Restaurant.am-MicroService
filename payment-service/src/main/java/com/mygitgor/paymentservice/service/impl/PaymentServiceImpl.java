package com.mygitgor.paymentservice.service.impl;

import com.mygitgor.paymentservice.entity.Order;
import com.mygitgor.paymentservice.respons.PaymentResponse;
import com.mygitgor.paymentservice.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Value("${strip.api.key}")
    private String stripeSecretKy;

    @Override
    public PaymentResponse createPaymentLink(Order order) throws Exception {
        Stripe.apiKey = stripeSecretKy;
        SessionCreateParams params = SessionCreateParams.builder().addPaymentMethodType(
                        SessionCreateParams
                                .PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
//                .setSuccessUrl("http://localhost:3000/payment/success"+order.getId())
                .setCancelUrl("http://localhost:3000/payment/fail")
                .addLineItem(SessionCreateParams.LineItem.builder()
                                .setQuantity(1L).setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("usd")
//                                .setUnitAmount((long)order.getTotalAmount()*100)
                                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                        .setName("taco food")
                                                        .build())
                                                .build()
                                ).build()
                ).build();

        Session session = Session.create(params);

        PaymentResponse response = new PaymentResponse();
//        response.setPayment_url(session.getUrl());

        return response;
    }
}
