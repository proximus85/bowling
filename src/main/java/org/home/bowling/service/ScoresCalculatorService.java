package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellAlgorithmWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculatorService {
    void setScoreCellAlgorithmWrapper(List<ScoreCellAlgorithmWrapper> scoresCells);

    List<ScoreCellAlgorithmWrapper> calculateScores();

    void setCalculationAlgorithmForLastScoreCell(ScoresCalculationStrategyService scoresCalculationStrategyService);
}

