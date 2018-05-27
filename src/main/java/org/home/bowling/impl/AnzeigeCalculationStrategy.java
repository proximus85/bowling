package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.service.ScoresCalculationStrategy;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AnzeigeCalculationStrategy extends CommonScoreCalculationStrategy implements ScoresCalculationStrategy {

    @Override
    public void recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
        super.calculateCurrentRoundScores(scoreCells, cellIndex);
    }

    @Override
    Integer calculateNextCellScores() {
        return 0;
    }
}
