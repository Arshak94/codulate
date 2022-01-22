package com.codulate.user.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class ViolationListener implements MessageListener {

    private static final String TOPIK = "violation";

    @Override
    @JmsListener(destination = TOPIK)
    public void onMessage(Message message) {
        try {
            /*ObjectMessage objectMessage = (ObjectMessage) message;
            String mes = (String) objectMessage.getObject();*/
            System.out.println("User Message: " + message);
        } catch (Exception e) {
            System.err.println("Received Exception : " + e);
        }
    }
}
