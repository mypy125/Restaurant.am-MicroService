package com.mygitgor.notificationservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mygitgor.notificationservice.conf.RabbitMQConfig;
import com.mygitgor.notificationservice.dto.NotificationResponseDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MassageHandler {
    private final JavaMailSender javaMailSender;

    public MassageHandler(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_DEPOSIT)
    public void receive(Message message) throws JsonProcessingException {
        System.out.println(message);
        byte[] body = message.getBody();
        String jsonBody = new String(body);
        ObjectMapper objectMapper = new ObjectMapper();
        NotificationResponseDto responseDto = objectMapper.readValue(jsonBody, NotificationResponseDto.class);
        System.out.println(responseDto);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(responseDto.getMail());
        mailMessage.setFrom("gor1990.mkhitatryan@gmail.com");

        mailMessage.setSubject("response");
        mailMessage.setText("Make deposit, sum:" + depositResponseDTO.getAmount());

        try {
            javaMailSender.send(mailMessage);
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }
}
