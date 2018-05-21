package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SpareCalculationServiceImpl implements ScoresCalculationStrategy {

    @Override
    public List<ScoreCellDto> recalculateScores(List<ScoreCellDto> scoreCells) {
        return scoreCells;
    }
}
