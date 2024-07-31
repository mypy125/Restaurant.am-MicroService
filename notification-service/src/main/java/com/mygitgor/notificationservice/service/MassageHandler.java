package com.mygitgor.notificationservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mygitgor.notificationservice.conf.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.javamail.JavaMailSender;

public class MassageHandler {
    private final JavaMailSender javaMailSender;

    public MassageHandler(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_DEPOSIT)
    public void receive(Message message) throws JsonProcessingException {

    }
}
