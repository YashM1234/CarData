package com.car.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FuelTypeCount {
    private long total;
    private int petrol;
    private int diesel;
}
