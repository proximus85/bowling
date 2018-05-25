package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.utils.ScoreCalculatorHelper;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StrikeScoresCalculationStrategyImpl implements ScoresCalculationStrategy {

    @Override
    public CellWrapper recalculateScores(List<CellWrapper> scoreCells, int cellIndex) {
        CellWrapper cellWrapper = scoreCells.get(cellIndex);
        ScoreCellDto scoreCellDto = cellWrapper.getScoreCellDto();

        Integer totalPoints = ScoreCalculatorHelper.calculateTotalSum(scoreCellDto.getScores()) +
                ScoreCalculatorHelper.calculateTotalSum(scoreCells.get(cellIndex + 1).getScoreCellDto().getScores());

        scoreCellDto.setTotalScores(totalPoints);
        return cellWrapper;
    }
}
