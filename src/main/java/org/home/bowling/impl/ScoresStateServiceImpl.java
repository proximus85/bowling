package org.home.bowling.impl;

import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.service.BowlingArrayScoresCalculatorService;
import org.home.bowling.service.ScoresStateService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ScoresStateServiceImpl implements ScoresStateService {

    @EJB
    private BowlingArrayScoresCalculatorService bowlingArrayScoresCalculatorService;

    @Override
    public void updateScoresState(List<ScoreCellAlgorithmDto> cellsWrappers, CurrentHitDto currentHitDto) {
        bowlingArrayScoresCalculatorService.recalculateArrayScores(cellsWrappers, currentHitDto);
    }
}
