package com.codulate.admin.service;

import com.codulate.dto.PointDTO;
import java.util.List;
import java.util.stream.Collectors;

public class ZoneIntersectionChecker {

    public static boolean contains(PointDTO pointDTO, List<PointDTO> points) {
        double minimumXAxis = findMinimumAxis(getXAxisFromPointsDto(points));
        double minimumYAxis = findMinimumAxis(getYAxisFromPointsDto(points));
        double minimumZAxis = findMinimumAxis(getZAxisFromPointsDto(points));
        double maximumXAxis = findMaximumAxis(getZAxisFromPointsDto(points));
        double maximumYAxis = findMaximumAxis(getZAxisFromPointsDto(points));
        double maximumZAxis = findMaximumAxis(getZAxisFromPointsDto(points));

        return pointDTO.getxAxis() <= maximumXAxis && pointDTO.getxAxis() >= minimumXAxis &&
                pointDTO.getyAxis() <= maximumYAxis && pointDTO.getyAxis() >= minimumYAxis &&
                pointDTO.getzAxis() <= maximumZAxis && pointDTO.getzAxis() >= minimumZAxis;
    }

    private static double findMinimumAxis(List<Double> axis){
        double minimumAxis = axis.get(0);
        for (Double ax: axis) {
            if (ax < minimumAxis)
                minimumAxis = ax;
        }
        return minimumAxis;
    }

    private static double findMaximumAxis(List<Double> axis){
        double maxAxis = axis.get(0);
        for (Double ax: axis) {
            if (ax > maxAxis)
                maxAxis = ax;
        }
        return maxAxis;
    }

    private static List<Double> getXAxisFromPointsDto (List<PointDTO> points){
       return points.stream().map(PointDTO::getxAxis).collect(Collectors.toList());
    }

    private static List<Double> getYAxisFromPointsDto (List<PointDTO> points){
        return points.stream().map(PointDTO::getyAxis).collect(Collectors.toList());
    }

    private static List<Double> getZAxisFromPointsDto (List<PointDTO> points){
        return points.stream().map(PointDTO::getzAxis).collect(Collectors.toList());
    }

}
