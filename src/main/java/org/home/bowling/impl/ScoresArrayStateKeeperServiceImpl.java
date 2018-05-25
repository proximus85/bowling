package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
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
    private ScoresCalculatorService scoresCalculatorService;

    @EJB
    private PinsStateService pinsStateService;

    @Override
    public List<CellWrapper> getInitialScoresArrayState() {//TODO move to initializationSErvice
        List<CellWrapper> scores = new ArrayList<>();
        for (int i = 0; i < SCORES_ARRAY_LENGTH; i++) {

            ScoreCellDto scoreCellDto = ScoreCellDto.builder()
                    .roundNo(i)
                    .scores(new ArrayList<>())
                    .totalScores(0)
                    .build();

            CellWrapper cellWrapper = CellWrapper.builder()
                    .scoreCellDto(scoreCellDto)
                    .scoresCalculationStrategy(new ScoresCalculationStrategy() {
                        @Override
                        public CellWrapper recalculateScores(List<CellWrapper> scoreCells, int cellIndex) {
                            return scoreCells.get(cellIndex);
                        }
                    })
                    .build();

            scores.add(cellWrapper);
        }
        return scores;
    }

    @Override
    public void updateScores(List<CellWrapper> cellWrappers,
                             CurrentHitDto currentHitDto) {

        pinsStateService.updatePinsState(cellWrappers, currentHitDto);

        ScoresCalculationStrategy scoresCalculationStrategy =
                scoresCalculationStrategyPickerService.pickScoresCalculationStrategy(cellWrappers, currentHitDto);

        scoresCalculatorService.setScoreCellAlgorithmWrapper(cellWrappers);
        scoresCalculatorService.setScoresCalculationStrategyForCurrentHit(scoresCalculationStrategy, currentHitDto);
        scoresCalculatorService.calculateScores();
    }
}
