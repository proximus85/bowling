package org.home.bowling.impl;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.CellWrapper;
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
                    .scoresCalculationStrategyService(new ScoresCalculationStrategy() {
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
                             CurrentThrowDto currentThrowDto) {

        pinsStateService.updatePinsState(cellWrappers, currentThrowDto);

        ScoresCalculationStrategy scoresCalculationStrategy =
                scoresCalculationStrategyPickerService.pickScoresCalculationStrategy(cellWrappers, currentThrowDto);

        scoresCalculatorService.setScoreCellAlgorithmWrapper(cellWrappers);
        scoresCalculatorService.setCalculationAlgorithmForLastScoreCell(scoresCalculationStrategy);
        scoresCalculatorService.calculateScores();
    }
}
