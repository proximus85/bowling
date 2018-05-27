package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.service.ScoresCalculationStrategy;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SpareCalculationStrategy extends CommonScoreCalculationStrategy implements ScoresCalculationStrategy {

    @Override
    public void recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
        super.calculateCurrentRoundScores(scoreCells, cellIndex);
    }

    Integer calculateNextCellScores() {
        List<Integer> hitPins = scoreCells.get(cellIndex + 1).getScoreCellDto().getHitPinsNumber();

        if (hitPins.size() >= 1) {
            return hitPins.get(0);
        }
        return 0;
    }
}
