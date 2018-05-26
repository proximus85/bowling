package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.service.ArrayScoresCalculatorService;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategyPickerService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ArrayScoresCalculatorServiceImpl implements ArrayScoresCalculatorService {

    @EJB
    private ScoresCalculationStrategyPickerService scoresCalculationStrategyPickerService;

    @Override
    public void recalculateArrayScores(List<ScoreCellAlgorithmDto> cellsWrappers, CurrentHitDto currentHitDto) {
        ScoresCalculationStrategy currentStrategy =
                scoresCalculationStrategyPickerService.pickScoresCalculationStrategy(cellsWrappers, currentHitDto);

        ScoreCellAlgorithmDto currentScoreCellAlgorithmDto = cellsWrappers.get(currentHitDto.getRoundNumber());
        currentScoreCellAlgorithmDto.setScoresCalculationStrategy(currentStrategy);

        recalculateAllCellsScores(cellsWrappers);
    }

    private void recalculateAllCellsScores(List<ScoreCellAlgorithmDto> cellsWrappers) {
        for (int i = 0; i < cellsWrappers.size(); i++) {
            ScoresCalculationStrategy scoresCalculationStrategy = cellsWrappers.get(i).getScoresCalculationStrategy();
            scoresCalculationStrategy.recalculateScores(cellsWrappers, i);
        }
    }
}