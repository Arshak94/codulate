package com.codulate.admin.service.impl;

import com.codulate.admin.exception.CoordinateValidationException;
import com.codulate.admin.exception.ZoneNameValidationException;
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
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ZoneServiceImpl implements ZoneService {

    private static final int MINIMUM_NUMBER_OF_POINTS = 3;
    private static final int MINIMUM_SIZE_OF_ZONE_NAME = 3;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public ZoneDTO create(ZoneDTO zone) {
        if (zone.getCoordinates().getPoints().size() < MINIMUM_NUMBER_OF_POINTS){
            throw new CoordinateValidationException(String.format(" %s or more coordinates must be provided", MINIMUM_NUMBER_OF_POINTS));
        } else if(zone.getName().length() < MINIMUM_SIZE_OF_ZONE_NAME){
            throw new ZoneNameValidationException(String.format("Zone name should contain more than %s characters ", MINIMUM_SIZE_OF_ZONE_NAME));
        }
         Zone savedZone = zoneRepository.save(zoneDtoToCollection(zone));
         return zoneCollectionToDto(savedZone);
    }

    @Override
    public ZoneDTO read(String id) {
        return zoneCollectionToDto( zoneRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public List<ZoneDTO> readAll() {
        return zoneRepository.findAll().stream().map(this::zoneCollectionToDto).collect(Collectors.toList());
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
