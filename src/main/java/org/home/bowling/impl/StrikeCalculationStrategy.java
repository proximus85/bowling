package org.home.bowling.impl;

import lombok.extern.java.Log;
import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.service.ScoresCalculationStrategy;

import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Level;

@Log
@Stateless
public class StrikeCalculationStrategy extends CommonScoreCalculationStrategy implements ScoresCalculationStrategy {

    @Override
    public void recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
        super.calculateCurrentRoundScores(scoreCells, cellIndex);
    }

    Integer calculateNextCellScores() {
        log.log(Level.ALL, String.format("Processing cellIndex: %s", cellIndex));
        List<Integer> nextCellHitPins = scoreCells.get(cellIndex + 1).getScoreCellDto().getHitPinsNumber();

        if (nextCellHitPins.size() > 1) {
            return nextCellHitPins.get(0) + nextCellHitPins.get(1);
        }

        if (nextCellHitPins.size() == 1) {
            return nextCellHitPins.get(0);
        }
        return 0;
    }
}
