package org.home.bowling.impl;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.ScoreCellAlgorithmWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresArrayStateKeeperService;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategyPickerService;
import org.home.bowling.service.ScoresCalculatorService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
public class ScoresArrayStateKeeperServiceImpl implements ScoresArrayStateKeeperService {

    public static final int SCORES_ARRAY_LENGTH = 10;
    public static final int INITIAL_TOTAL_SCORES = 10;

    @EJB
    private ScoresCalculationStrategyPickerService scoresCalculationStrategyPickerService;

    @EJB
    private ScoresCalculatorService scoresCalculatorService;

    @Override
    public List<ScoreCellDto> getInitialScoresArrayState() {
        List<ScoreCellDto> scores = new ArrayList<>();
        for (int i = 1; i <= SCORES_ARRAY_LENGTH; i++) {

            ScoreCellDto scoreCellDto = ScoreCellDto.builder()
                    .roundNo(i)
                    .scores(Arrays.asList(1, 2))
                    .totalScores(INITIAL_TOTAL_SCORES)
                    .build();

            scores.add(scoreCellDto);
        }
        return scores;
    }

    @Override
    public List<ScoreCellAlgorithmWrapper> updateScores(List<ScoreCellAlgorithmWrapper> scores,
                                                        CurrentThrowDto currentThrowDto) {

        ScoresCalculationStrategy scoresCalculationStrategy =
                scoresCalculationStrategyPickerService.pickScoresCalculationStrategy(scores, currentThrowDto);

        scoresCalculatorService.setScoresCells(scores);
        scoresCalculatorService.setCalculationAlgorithmForLastScoreCell(scoresCalculationStrategy);
        return scoresCalculatorService.calculateScores();
    }
}
