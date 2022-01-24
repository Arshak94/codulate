package com.codulate.user.service;

import com.codulate.dto.ViolationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
public class ViolationListener implements MessageListener {

    Logger LOGGER = LoggerFactory.getLogger(ViolationListener.class);
    private static final String TOPIK = "violation";

    @Override
    @JmsListener(destination = TOPIK)
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            ViolationInfo violationInfo = (ViolationInfo) objectMessage.getObject();
            LOGGER.info("User Message: {} " ,  violationInfo.getMessage());
        } catch (Exception e) {
            LOGGER.error("Received Exception : {} " ,  e.getMessage());
        }
    }
}
