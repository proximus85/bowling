package org.home.bowling.impl;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.ScoreCellAlgorithmWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScoresArrayStateKeeperServiceImpl implements ScoresArrayStateKeeperService {

    private static final int SCORES_ARRAY_LENGTH = 10;

    @EJB
    private ScoresCalculationStrategyPickerService scoresCalculationStrategyPickerService;

    @EJB
    private ScoresCalculatorService scoresCalculatorService;

    @EJB
    private PinsStateService pinsStateService;

    @Override
    public List<ScoreCellAlgorithmWrapper> getInitialScoresArrayState() {//TODO move to initializationSErvice
        List<ScoreCellAlgorithmWrapper> scores = new ArrayList<>();
        for (int i = 0; i < SCORES_ARRAY_LENGTH; i++) {

            ScoreCellDto scoreCellDto = ScoreCellDto.builder()
                    .roundNo(i)
                    .scores(new ArrayList<>())
                    .totalScores(0)
                    .build();

            ScoreCellAlgorithmWrapper scoreCellAlgorithmWrapper = ScoreCellAlgorithmWrapper.builder()
                    .scoreCellDto(scoreCellDto)
                    .scoresCalculationStrategyService(new ScoresCalculationStrategyService() {
                        @Override
                        public ScoreCellAlgorithmWrapper recalculateScores(List<ScoreCellAlgorithmWrapper> scoreCells, int cellIndex) {
                            return scoreCells.get(cellIndex);
                        }
                    })
                    .build();

            scores.add(scoreCellAlgorithmWrapper);
        }
        return scores;
    }

    @Override
    public List<ScoreCellAlgorithmWrapper> updateScores(List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers,
                                                        CurrentThrowDto currentThrowDto) {

        pinsStateService.updatePinsState(scoreCellAlgorithmWrappers, currentThrowDto);

        ScoresCalculationStrategyService scoresCalculationStrategyService =
                scoresCalculationStrategyPickerService.pickScoresCalculationStrategy(scoreCellAlgorithmWrappers, currentThrowDto);

        scoresCalculatorService.setScoreCellAlgorithmWrapper(scoreCellAlgorithmWrappers);
        scoresCalculatorService.setCalculationAlgorithmForLastScoreCell(scoresCalculationStrategyService);
        return scoresCalculatorService.calculateScores();
    }
}
