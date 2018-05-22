package org.home.bowling.service;

import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculatorService {
    void setScoresCells(List<ScoreCellAlgorithmWrapper> scoresCells);

    List<ScoreCellAlgorithmWrapper> calculateScores();

    void setCalculationAlgorithmForLastScoreCell(ScoresCalculationStrategy scoresCalculationStrategy);
}

