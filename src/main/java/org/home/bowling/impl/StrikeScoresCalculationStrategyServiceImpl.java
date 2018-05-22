package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategyService;
import org.home.bowling.utils.ScoreCalculatorHelper;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

@Stateless
public class StrikeScoresCalculationStrategyServiceImpl implements ScoresCalculationStrategyService {

    @Override
    public ScoreCellAlgorithmWrapper recalculateScores(List<ScoreCellAlgorithmWrapper> scoreCells, int cellIndex) {
        ScoreCellAlgorithmWrapper scoreCellAlgorithmWrapper = scoreCells.get(cellIndex);
        ScoreCellDto scoreCellDto = scoreCellAlgorithmWrapper.getScoreCellDto();

        Integer totalPoints = ScoreCalculatorHelper.calculateTotalSum(scoreCellDto.getScores()) +
                ScoreCalculatorHelper.calculateTotalSum(scoreCells.get(cellIndex + 1).getScoreCellDto().getScores());

        scoreCellDto.setTotalScores(totalPoints);
        return scoreCellAlgorithmWrapper;
    }
}
