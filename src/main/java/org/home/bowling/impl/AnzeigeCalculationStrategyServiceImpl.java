package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;

import java.util.List;

public class AnzeigeCalculationStrategyServiceImpl implements ScoresCalculationStrategy {

    @Override
    public List<ScoreCellDto> recalculateScores(List<ScoreCellDto> scoreCells) {

        return scoreCells;
    }
}
