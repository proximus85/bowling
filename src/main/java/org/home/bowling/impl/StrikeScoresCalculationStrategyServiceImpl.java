package org.home.bowling.impl;

import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StrikeScoresCalculationStrategyServiceImpl implements ScoresCalculationStrategy {

    @Override
    public ScoreCellAlgorithmWrapper recalculateScores(List<ScoreCellAlgorithmWrapper> scoreCells) {
        throw new IllegalStateException("not supported operation");
    }
}
