package org.home.bowling.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreCellDto {
    private Integer roundNo;
    private List<Integer> hitPinsNumber;
    private Integer totalScores;
}
