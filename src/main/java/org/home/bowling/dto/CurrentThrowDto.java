package org.home.bowling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CurrentThrowDto {
    Integer roundNumber;
    Integer throwNumber;
    Integer pinsHited;
}
