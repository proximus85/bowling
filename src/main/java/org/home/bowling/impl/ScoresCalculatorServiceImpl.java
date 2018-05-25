package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.service.ScoresCalculationStrategyService;
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
    public void setCalculationAlgorithmForLastScoreCell(ScoresCalculationStrategyService scoresCalculationStrategyService) {
        int indexOfLastElement = cellWrappers.size() - 1;
        cellWrappers.get(indexOfLastElement)
                .setScoresCalculationStrategyService(scoresCalculationStrategyService);
    }

    @Override
    public void calculateScores() {

        for (int i = 0; i < cellWrappers.size(); i++) {
            cellWrappers.get(i).getScoresCalculationStrategyService()
                    .recalculateScores(cellWrappers, i);

        }
    }
}