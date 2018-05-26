package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.utils.ScoreCalculatorHelper;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SpareCalculationImpl implements ScoresCalculationStrategy {

    @Override
    public ScoreCellAlgorithmDto recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
        ScoreCellAlgorithmDto scoreCellAlgorithmDto = scoreCells.get(cellIndex);
        ScoreCellDto scoreCellDto = scoreCellAlgorithmDto.getScoreCellDto();

        Integer totalPoints = ScoreCalculatorHelper.calculateTotalSum(scoreCellDto.getScores()) +
                scoreCells.get(cellIndex + 1).getScoreCellDto().getScores().get(0);

        scoreCellDto.setTotalScores(totalPoints);
        return scoreCellAlgorithmDto;
    }
}
