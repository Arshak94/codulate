package com.codulate.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesSender {

    private static final String TOPIK = "coordinate";

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        try {
            jmsTemplate.convertAndSend(TOPIK, message);
        } catch (Exception e) {
            System.err.print("Recieved Exception during send Message: " + e);
        }
    }
}
