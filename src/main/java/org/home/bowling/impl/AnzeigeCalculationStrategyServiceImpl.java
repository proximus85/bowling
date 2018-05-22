package org.home.bowling.impl;

import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import java.util.List;

public class AnzeigeCalculationStrategyServiceImpl implements ScoresCalculationStrategy {

    @Override
    public ScoreCellAlgorithmWrapper recalculateScores(List<ScoreCellAlgorithmWrapper> scoreCells) {
        throw new IllegalStateException("operation not supported");
    }
}
