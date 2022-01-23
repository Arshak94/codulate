package com.codulate.admin.service;

import com.codulate.dto.CoordinatesDTO;
import com.codulate.dto.ZoneDTO;

import java.util.List;

public interface ZoneService {
    ZoneDTO create(ZoneDTO zone);
    ZoneDTO update(ZoneDTO zone, Long id);
    ZoneDTO read(String id);
    List<ZoneDTO> readAll();
    ZoneDTO delete(Long id);
}
