package org.home.bowling.impl;

import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculatorService;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScoresCalculatorServiceImpl implements ScoresCalculatorService {

    private List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers;

    @Override
    public void setScoresCells(List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers) {
        this.scoreCellAlgorithmWrappers = scoreCellAlgorithmWrappers;
    }

    @Override
    public void setCalculationAlgorithmForLastScoreCell(ScoresCalculationStrategy scoresCalculationStrategy) {
        int indexOfLastElement = scoreCellAlgorithmWrappers.size() - 1;
        scoreCellAlgorithmWrappers.get(indexOfLastElement)
                .setScoresCalculationStrategy(scoresCalculationStrategy);
    }

    @Override
    public List<ScoreCellAlgorithmWrapper> calculateScores() {
        List<ScoreCellAlgorithmWrapper> newScoreCellAlgorithmWrappers = new ArrayList<>();

        for (int i = 0; i < scoreCellAlgorithmWrappers.size(); i++) {
            ScoreCellAlgorithmWrapper scoreCellAlgorithmWrapper = scoreCellAlgorithmWrappers.get(i)
                    .getScoresCalculationStrategy()
                    .recalculateScores(scoreCellAlgorithmWrappers, i);

            newScoreCellAlgorithmWrappers.add(scoreCellAlgorithmWrapper);
        }
        return newScoreCellAlgorithmWrappers;
    }
}
