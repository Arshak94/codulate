package com.codulate.dto;

import java.util.List;

public class CoordinatesDTO {
    private List<PointDTO> points;

    public CoordinatesDTO() {
    }

    public CoordinatesDTO(List<PointDTO> points) {
        this.points = points;
    }

    public List<PointDTO> getPoints() {
        return points;
    }

    public void setPoints(List<PointDTO> points) {
        this.points = points;
    }
}
