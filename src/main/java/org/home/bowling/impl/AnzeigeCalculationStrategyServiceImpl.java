package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AnzeigeCalculationStrategyServiceImpl implements ScoresCalculationStrategy {

    @Override
    public ScoreCellAlgorithmWrapper recalculateScores(List<ScoreCellAlgorithmWrapper> scoreCells, int cellIndex) {
        ScoreCellAlgorithmWrapper scoreCellAlgorithmWrapper = scoreCells.get(cellIndex);
        ScoreCellDto scoreCellDto = scoreCellAlgorithmWrapper.getScoreCellDto();
        scoreCellDto.setTotalScores(calculateTotalSum(scoreCellDto.getScores()));
        return scoreCellAlgorithmWrapper;
    }

    private Integer calculateTotalSum(List<Integer> scores) {
        int total = 0;
        for (Integer score : scores) {
            total += score;
        }
        return total;
    }
}
