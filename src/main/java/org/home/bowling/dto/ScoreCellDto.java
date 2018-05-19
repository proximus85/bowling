package org.home.bowling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ScoreCellDto {

    private Integer roundNo;
    private List<Integer> scores;
    private Integer totalScores;

}
