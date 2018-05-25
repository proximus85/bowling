package org.home.bowling.service;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.CurrentHitDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculatorService {
    void setScoreCellAlgorithmWrapper(List<CellWrapper> scoresCells);

    void calculateScores();

    void setScoresCalculationStrategyForCurrentHit(ScoresCalculationStrategy scoresCalculationStrategy, CurrentHitDto currentHitDto);
}

