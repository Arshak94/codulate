package com.codulate.dto;

import java.io.Serializable;

public class PointDTO implements Serializable {
    private double xAxis;
    private double yAxis;
    private double zAxis;

    public PointDTO() {
    }

    public PointDTO(double xAxis, double yAxis, double zAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
    }

    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getyAxis() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    public double getzAxis() {
        return zAxis;
    }

    public void setzAxis(double zAxis) {
        this.zAxis = zAxis;
    }

    @Override
    public String toString() {
        return "PointDTO{" +
                "xAxis=" + xAxis +
                ", yAxis=" + yAxis +
                ", zAxis=" + zAxis +
                '}';
    }
}
