package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
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
    public void setCalculationAlgorithmForLastScoreCell(ScoresCalculationStrategy scoresCalculationStrategy) {
        int indexOfLastElement = cellWrappers.size() - 1;
        cellWrappers.get(indexOfLastElement)
                .setScoresCalculationStrategy(scoresCalculationStrategy);
    }

    @Override
    public void calculateScores() {

        for (int i = 0; i < cellWrappers.size(); i++) {
            cellWrappers.get(i).getScoresCalculationStrategy()
                    .recalculateScores(cellWrappers, i);

        }
    }
}