package com.codulate.admin.service;

import org.springframework.jms.annotation.JmsListener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class CoordinatesListener implements MessageListener {

    private static final String TOPIK="coordinates";
    @Override
    @JmsListener(destination = TOPIK)
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            String mes = (String)objectMessage.getObject();
            System.out.println("Received Message: "+ mes);
        } catch(Exception e) {
            System.err.println("Received Exception : "+ e);
        }
    }
}
