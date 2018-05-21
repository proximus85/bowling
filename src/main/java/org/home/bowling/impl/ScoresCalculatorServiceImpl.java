package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculatorService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ScoresCalculatorServiceImpl implements ScoresCalculatorService {

    private List<ScoreCellDto> scoreCells;

    @Override
    public void setScoresCells(List<ScoreCellDto> scoresCells) {
        this.scoreCells = scoresCells;
    }

    @Override
    public List<ScoreCellDto> calculateScores(ScoresCalculationStrategy scoresCalculationStrategy) {
        return scoresCalculationStrategy.recalculateScores(scoreCells);
    }

}
