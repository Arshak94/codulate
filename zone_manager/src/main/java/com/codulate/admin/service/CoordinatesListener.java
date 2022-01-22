package com.codulate.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
public class CoordinatesListener implements MessageListener {

    private static final String TOPIK = "coordinate";

    @Autowired
    private ViolationProducer violationProducer;

    @Override
    @JmsListener(destination = TOPIK)
    public void onMessage(Message message) {
        try {
            //ObjectMessage objectMessage = (ObjectMessage) message;
            /*String mes = (String) objectMessage.getObject();*/
            //check
            System.out.println("Zone Manager Message: " + message);
            violationProducer.sendMessage("ha jogi axper jan");

        } catch (Exception e) {
            System.err.println("Received Exception : " + e);
        }
    }
}
