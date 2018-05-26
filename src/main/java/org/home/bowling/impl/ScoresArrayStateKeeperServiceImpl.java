package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.CurrentHitDto;
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
    private ArrayScoresCalculatorService arrayScoresCalculatorService;

    @EJB
    private PinsStateService pinsStateService;

    @EJB
    private ScoresStateService scoresStateService;

    @Override
    public List<ScoreCellAlgorithmDto> getInitialScoresArrayState() {//TODO move to initializationSErvice
        List<ScoreCellAlgorithmDto> scores = new ArrayList<>();
        for (int i = 0; i < SCORES_ARRAY_LENGTH; i++) {

            ScoreCellDto scoreCellDto = ScoreCellDto.builder()
                    .roundNo(i)
                    .scores(new ArrayList<>())
                    .totalScores(0)
                    .build();

            ScoreCellAlgorithmDto scoreCellAlgorithmDto = ScoreCellAlgorithmDto.builder()
                    .scoreCellDto(scoreCellDto)
                    .scoresCalculationStrategy(new ScoresCalculationStrategy() {
                        @Override
                        public ScoreCellAlgorithmDto recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
                            return scoreCells.get(cellIndex);
                        }
                    })
                    .build();

            scores.add(scoreCellAlgorithmDto);
        }
        return scores;
    }

    @Override
    public void updateScores(List<ScoreCellAlgorithmDto> cellsWrappers, CurrentHitDto currentHitDto) {
        pinsStateService.updatePinsState(cellsWrappers, currentHitDto);
        scoresStateService.updateScoresState(cellsWrappers, currentHitDto);
    }
}
