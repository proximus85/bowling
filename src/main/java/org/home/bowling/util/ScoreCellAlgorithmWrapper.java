package org.home.bowling.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;

@Getter
@Setter
@AllArgsConstructor
public class ScoreCellAlgorithmWrapper {
    private ScoreCellDto scoreCellDto;
    private ScoresCalculationStrategy scoresCalculationStrategy;
}
