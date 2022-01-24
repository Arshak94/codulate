package com.codulate.dto;

import java.io.Serializable;
import java.util.List;

public class CoordinatesDTO implements Serializable {
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
