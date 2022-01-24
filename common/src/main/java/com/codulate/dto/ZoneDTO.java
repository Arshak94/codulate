package com.codulate.dto;


import java.io.Serializable;

public class ZoneDTO implements Serializable {
    private String name;
    private CoordinatesDTO coordinates;

    public ZoneDTO() {
    }

    public ZoneDTO(String name, CoordinatesDTO coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordinatesDTO getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesDTO coordinates) {
        this.coordinates = coordinates;
    }
}
