package com.codulate.admin.service;

import com.codulate.dto.ZoneDTO;

import java.util.List;

public interface ZoneService {
    ZoneDTO create(ZoneDTO zone);
    ZoneDTO read(String id);
    List<ZoneDTO> readAll();
}
