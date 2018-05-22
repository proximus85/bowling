package org.home.bowling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.home.bowling.service.ScoresCalculationStrategyService;

@Getter
@Setter
@AllArgsConstructor
public class ScoreCellAlgorithmWrapper {
    private ScoreCellDto scoreCellDto;
    private ScoresCalculationStrategyService scoresCalculationStrategyService;
}
