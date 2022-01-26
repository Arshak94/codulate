package com.codulate.admin.service;

import com.codulate.dto.PointDTO;

import java.util.List;

public class ZoneIntersectionChecker {

    public static boolean contains(PointDTO pointDTO, List<PointDTO> points) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
            if ((points.get(i).getyAxis() > pointDTO.getyAxis()) != (points.get(j).getyAxis() > pointDTO.getyAxis()) &&
                    (pointDTO.getxAxis() < (points.get(j).getxAxis() - points.get(i).getxAxis()) *
                            (pointDTO.getyAxis() - points.get(i).getyAxis()) / (points.get(j).getyAxis() - points.get(i).getyAxis()) + points.get(i).getxAxis())) {
                result = !result;
            }
        }
        return result;
    }
}
