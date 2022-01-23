package com.codulate.admin.service.impl;

import com.codulate.admin.repository.ZoneRepository;
import com.codulate.admin.service.ZoneService;
import com.codulate.dto.CoordinatesDTO;
import com.codulate.dto.PointDTO;
import com.codulate.dto.ZoneDTO;
import com.codulate.model.Coordinates;
import com.codulate.model.Point;
import com.codulate.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public ZoneDTO create(ZoneDTO zone) {
         Zone savedZone = zoneRepository.save(zoneDtoToCollection(zone));
         return zoneCollectionToDto(savedZone);
    }

    @Override
    public ZoneDTO update(ZoneDTO zone, Long id) {
        return null;
    }

    @Override
    public ZoneDTO read(String id) {
        return zoneCollectionToDto( zoneRepository.findById(id).orElseThrow(()-> new RuntimeException()));
    }

    @Override
    public List<ZoneDTO> readAll() {
        return zoneRepository.findAll().stream().map(this::zoneCollectionToDto).collect(Collectors.toList());
    }

    @Override
    public ZoneDTO delete(Long id) {
        return null;
    }

    private Zone zoneDtoToCollection(ZoneDTO zoneDTO){
        return new Zone(zoneDTO.getName(), coordinatesDtoToCollection(zoneDTO.getCoordinates()));
    }

    private Coordinates coordinatesDtoToCollection(CoordinatesDTO coordinatesDTO){
        return new Coordinates(coordinatesDTO.getPoints().stream().map(this::pointDtoToCollection).collect(Collectors.toList()));
    }

    private Point pointDtoToCollection(PointDTO pointDTO){
        return new Point(pointDTO.getxAxis(), pointDTO.getyAxis(), pointDTO.getzAxis());
    }

    private ZoneDTO zoneCollectionToDto(Zone zone){
        return new ZoneDTO(zone.getName(), coordinatesCollectionToDto(zone.getCoordinates()));
    }

    private CoordinatesDTO coordinatesCollectionToDto(Coordinates coordinates){
        return new CoordinatesDTO(coordinates.getPoints().stream().map(this::pointsCollectionToDto).collect(Collectors.toList()));
    }

    private PointDTO pointsCollectionToDto(Point point){
        return new PointDTO(point.getxAxis(), point.getyAxis(), point.getzAxis());
    }
}
