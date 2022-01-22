package com.codulate.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ViolationProducer {

    private static final String TOPIK = "violation";

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        try {
            jmsTemplate.convertAndSend(TOPIK, message);
        } catch (Exception e) {
            System.err.print("Recieved Exception during send Message: " + e);
        }
    }
}
