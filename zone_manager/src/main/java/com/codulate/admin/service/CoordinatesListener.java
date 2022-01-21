package com.codulate.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
public class CoordinatesListener implements MessageListener {

    private static final String TOPIK="coordinates";

    @Autowired
    private ViolationProducer violationProducer;

    @Override
    @JmsListener(destination = TOPIK)
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            String mes = (String)objectMessage.getObject();
            //check
            violationProducer.sendMessage("inch vor message");
            System.out.println("Received Message: "+ mes);
        } catch(Exception e) {
            System.err.println("Received Exception : "+ e);
        }
    }
}
