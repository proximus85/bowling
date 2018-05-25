package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategyService;
import org.home.bowling.utils.ScoreCalculatorHelper;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SpareCalculationServiceImpl implements ScoresCalculationStrategyService {

    @Override
    public CellWrapper recalculateScores(List<CellWrapper> scoreCells, int cellIndex) {
        CellWrapper cellWrapper = scoreCells.get(cellIndex);
        ScoreCellDto scoreCellDto = cellWrapper.getScoreCellDto();

        Integer totalPoints = ScoreCalculatorHelper.calculateTotalSum(scoreCellDto.getScores()) +
                scoreCells.get(cellIndex + 1).getScoreCellDto().getScores().get(0);

        scoreCellDto.setTotalScores(totalPoints);
        return cellWrapper;
    }
}
