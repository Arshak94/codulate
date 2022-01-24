package com.codulate.admin.service;

import com.codulate.dto.PointDTO;
import com.codulate.dto.ViolationInfo;
import com.codulate.dto.ZoneDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.List;

@Component
public class CoordinatesListener implements MessageListener {

    Logger LOGGER = LoggerFactory.getLogger(CoordinatesListener.class);

    private static final String TOPIK = "coordinate";

    @Autowired
    private ViolationProducer violationProducer;
    @Autowired
    private ZoneService zoneService;

    @Override
    @JmsListener(destination = TOPIK)
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            PointDTO pointDTO = (PointDTO) objectMessage.getObject();
            LOGGER.info("Zone Manager Message: {} " , pointDTO);
            List<ZoneDTO> zoneDTOS = zoneService.readAll();
            for (ZoneDTO zoneDto: zoneDTOS) {
                if (ZoneIntersectionChecker.contains(pointDTO,zoneDto.getCoordinates().getPoints())){
                    violationProducer.sendMessage(new ViolationInfo(String.format("Zone %s Violated", zoneDto.getName())));
                    break;
                }
            }
        } catch (Exception e) {
            LOGGER.error("Received Exception :  {}" ,  e.getMessage());
        }
    }
}
