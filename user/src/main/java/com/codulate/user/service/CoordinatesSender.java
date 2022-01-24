package com.codulate.user.service;

import com.codulate.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesSender {

    Logger LOGGER = LoggerFactory.getLogger(CoordinatesSender.class);

    private static final String TOPIK = "coordinate";

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(PointDTO pointDTO) {
        try {
            jmsTemplate.convertAndSend(TOPIK, pointDTO);
        } catch (Exception e) {
            LOGGER.error("Recieved Exception during send Message: {}" , e.getMessage());
        }
    }
}
