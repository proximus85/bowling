package org.home.bowling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HeatDto {
    Integer roundNumber;
    Integer heatNumber;
    Integer pinsHeated;
}
