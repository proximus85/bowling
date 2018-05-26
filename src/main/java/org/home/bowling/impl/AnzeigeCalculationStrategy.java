package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.utils.ScoreCalculatorHelper;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AnzeigeCalculationStrategy implements ScoresCalculationStrategy {

    @Override
    public void recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
        ScoreCellAlgorithmDto scoreCellAlgorithmDto = scoreCells.get(cellIndex);
        ScoreCellDto scoreCellDto = scoreCellAlgorithmDto.getScoreCellDto();

        int totalScores = ScoreCalculatorHelper.calculateTotalSum(scoreCellDto.getHitPinsNumber());
        if (cellIndex - 1 >= 0) {
            totalScores += scoreCells.get(cellIndex - 1).getScoreCellDto().getTotalScores();
        }
        scoreCellDto.setTotalScores(totalScores);
    }
}
