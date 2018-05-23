package org.home.bowling.dto;

import lombok.*;
import org.home.bowling.service.ScoresCalculationStrategyService;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScoreCellAlgorithmWrapper {
    private ScoreCellDto scoreCellDto;
    private ScoresCalculationStrategyService scoresCalculationStrategyService;
}
