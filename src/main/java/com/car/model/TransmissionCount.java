package com.car.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Data
@Builder
public class TransmissionCount {
    private Map<String, FuelTypeCount> transmissionType;
}
