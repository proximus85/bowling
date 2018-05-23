package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmWrapper;
import org.home.bowling.service.ScoresCalculationStrategyService;
import org.home.bowling.service.ScoresCalculatorService;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScoresCalculatorServiceImpl implements ScoresCalculatorService {

    private List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers;

    @Override
    public void setScoreCellAlgorithmWrapper(List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers) {
        this.scoreCellAlgorithmWrappers = scoreCellAlgorithmWrappers;
    }

    @Override
    public void setCalculationAlgorithmForLastScoreCell(ScoresCalculationStrategyService scoresCalculationStrategyService) {
        int indexOfLastElement = scoreCellAlgorithmWrappers.size() - 1;
        scoreCellAlgorithmWrappers.get(indexOfLastElement)
                .setScoresCalculationStrategyService(scoresCalculationStrategyService);
    }

    @Override
    public List<ScoreCellAlgorithmWrapper> calculateScores() {
        List<ScoreCellAlgorithmWrapper> newScoreCellAlgorithmWrappers = new ArrayList<>();

        for (int i = 0; i < scoreCellAlgorithmWrappers.size(); i++) {
            ScoreCellAlgorithmWrapper scoreCellAlgorithmWrapper = scoreCellAlgorithmWrappers.get(i)
                    .getScoresCalculationStrategyService()
                    .recalculateScores(scoreCellAlgorithmWrappers, i);

            newScoreCellAlgorithmWrappers.add(scoreCellAlgorithmWrapper);
        }
        return newScoreCellAlgorithmWrappers;
    }
}
