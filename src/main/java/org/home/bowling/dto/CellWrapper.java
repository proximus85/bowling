package org.home.bowling.dto;

import lombok.*;
import org.home.bowling.service.ScoresCalculationStrategy;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CellWrapper {
    private ScoreCellDto scoreCellDto;
    private ScoresCalculationStrategy scoresCalculationStrategy;
}
