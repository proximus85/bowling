package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.service.ArrayScoresCalculatorService;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategyPickerService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ArrayArrayScoresCalculatorServiceImpl implements ArrayScoresCalculatorService {

    @EJB
    private ScoresCalculationStrategyPickerService scoresCalculationStrategyPickerService;

    @Override
    public void recalculateArrayScores(List<CellWrapper> cellsWrappers, CurrentHitDto currentHitDto) {
        ScoresCalculationStrategy currentStrategy =
                scoresCalculationStrategyPickerService.pickScoresCalculationStrategy(cellsWrappers, currentHitDto);

        CellWrapper currentCellWrapper = cellsWrappers.get(currentHitDto.getRoundNumber());
        currentCellWrapper.setScoresCalculationStrategy(currentStrategy);

        recalculateAllCellsScores(cellsWrappers);
    }

    private void recalculateAllCellsScores(List<CellWrapper> cellsWrappers) {
        for (int i = 0; i < cellsWrappers.size(); i++) {
            ScoresCalculationStrategy scoresCalculationStrategy = cellsWrappers.get(i).getScoresCalculationStrategy();
            scoresCalculationStrategy.recalculateScores(cellsWrappers, i);
        }
    }
}