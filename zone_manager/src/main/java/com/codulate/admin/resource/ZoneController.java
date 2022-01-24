package com.codulate.admin.resource;

import com.codulate.admin.service.ZoneService;
import com.codulate.dto.ZoneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @PostMapping
    public ZoneDTO create(@RequestBody ZoneDTO zone){
        return zoneService.create(zone);
    }

    @GetMapping("/{id}")
    public ZoneDTO read(@PathVariable String id){
        return zoneService.read(id);
    }

    @GetMapping("/all")
    public List<ZoneDTO> read(){
        return zoneService.readAll();
    }

}
