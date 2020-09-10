package com.epam.training.solution;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {

    private String coordinateX;
    private String coordinateY;
    private String state;

}
