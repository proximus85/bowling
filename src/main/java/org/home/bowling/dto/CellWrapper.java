package org.home.bowling.dto;

import lombok.*;
import org.home.bowling.service.ScoresCalculationStrategyService;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CellWrapper {
    private ScoreCellDto scoreCellDto;
    private ScoresCalculationStrategyService scoresCalculationStrategyService;
}
