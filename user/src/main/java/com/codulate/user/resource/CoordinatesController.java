package com.codulate.user.resource;

import com.codulate.dto.PointDTO;
import com.codulate.user.service.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coordinate")
public class CoordinatesController {

    @Autowired
    private CoordinateService coordinateService;

    @PostMapping("/send")
    public void send(@RequestBody PointDTO pointDTO){
        coordinateService.send(pointDTO);
    }

}
