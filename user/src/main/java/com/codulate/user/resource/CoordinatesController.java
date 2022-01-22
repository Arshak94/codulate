package com.codulate.user.resource;

import com.codulate.dto.CoordinatesDTO;
import com.codulate.dto.PointDTO;
import com.codulate.user.service.CoordinatesSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coordinate")
public class CoordinatesController {

    @Autowired
    private CoordinatesSender sender;

    public ResponseEntity send(@RequestBody PointDTO pointDTO){
        return null;
    }

    /*@GetMapping("/get")
    public void get(@RequestBody CoordinatesDTO coordinatesDTO){
        sender.sendMessage("Arshak du mer mec axpern es");
    }*/
}
