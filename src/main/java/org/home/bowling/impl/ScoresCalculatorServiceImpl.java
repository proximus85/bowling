package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculatorService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ScoresCalculatorServiceImpl implements ScoresCalculatorService {

    private List<CellWrapper> cellWrappers;

    @Override
    public void setScoreCellAlgorithmWrapper(List<CellWrapper> cellWrappers) {
        this.cellWrappers = cellWrappers;
    }

    @Override
    public void setScoresCalculationStrategyForCurrentHit(ScoresCalculationStrategy scoresCalculationStrategy, CurrentHitDto currentHitDto) {
        int indexOfLastElement = cellWrappers.size() - 1;
        cellWrappers.get(indexOfLastElement)
                .setScoresCalculationStrategy(scoresCalculationStrategy);
    }

    @Override
    public void calculateScores() {

        for (int i = 0; i < cellWrappers.size(); i++) {
            ScoresCalculationStrategy scoresCalculationStrategy = cellWrappers.get(i).getScoresCalculationStrategy();
            scoresCalculationStrategy.recalculateScores(cellWrappers, i);
        }
    }
}