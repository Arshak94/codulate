package com.codulate.user.service;

import com.codulate.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateService {
    @Autowired
    private CoordinatesSender sender;

    public void send(PointDTO pointDTO){
        sender.sendMessage(pointDTO);
    }
}
