package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.utils.ScoreCalculatorHelper;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AnzeigeCalculationStrategyImpl implements ScoresCalculationStrategy {

    @Override
    public CellWrapper recalculateScores(List<CellWrapper> scoreCells, int cellIndex) {
        CellWrapper cellWrapper = scoreCells.get(cellIndex);
        ScoreCellDto scoreCellDto = cellWrapper.getScoreCellDto();
        scoreCellDto.setTotalScores(ScoreCalculatorHelper.calculateTotalSum(scoreCellDto.getScores()));
        return cellWrapper;
    }
}
