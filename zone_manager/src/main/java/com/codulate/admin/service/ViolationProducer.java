package com.codulate.admin.service;

import com.codulate.dto.ViolationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ViolationProducer {

    Logger LOGGER = LoggerFactory.getLogger(CoordinatesListener.class);

    private static final String TOPIK = "violation";

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(ViolationInfo message) {
        try {
            jmsTemplate.convertAndSend(TOPIK, message);
        } catch (Exception e) {
            LOGGER.error("Recieved Exception during send Message: {} " , e.getMessage());
        }
    }
}
