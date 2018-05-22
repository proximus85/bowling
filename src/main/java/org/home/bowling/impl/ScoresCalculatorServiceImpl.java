package org.home.bowling.impl;

import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculatorService;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScoresCalculatorServiceImpl implements ScoresCalculatorService {

    private List<ScoreCellAlgorithmWrapper> previousScoreCellAlgorithmWrappers;

    @Override
    public void setScoresCells(List<ScoreCellAlgorithmWrapper> scoresCells) {
        this.previousScoreCellAlgorithmWrappers = scoresCells;
    }

    @Override
    public void setCalculationAlgorithmForLastScoreCell(ScoresCalculationStrategy scoresCalculationStrategy) {
        int indexOfLastElement = previousScoreCellAlgorithmWrappers.size() - 1;

        previousScoreCellAlgorithmWrappers.get(indexOfLastElement)
                .setScoresCalculationStrategy(scoresCalculationStrategy);
    }

    @Override
    public List<ScoreCellAlgorithmWrapper> calculateScores(ScoresCalculationStrategy scoresCalculationStrategy) {
        List<ScoreCellAlgorithmWrapper> newScoreCellAlgorithmWrappers = new ArrayList<>();

        for (ScoreCellAlgorithmWrapper re : previousScoreCellAlgorithmWrappers) {
            newScoreCellAlgorithmWrappers.add(re.getScoresCalculationStrategy()
                    .recalculateScores(newScoreCellAlgorithmWrappers));
        }
        return newScoreCellAlgorithmWrappers;
    }
}
