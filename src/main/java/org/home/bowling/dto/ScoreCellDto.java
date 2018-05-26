package org.home.bowling.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ScoreCellDto {
    private Integer roundNo;
    private List<Integer> hitPinsNumber;
    private Integer totalScores;
}
