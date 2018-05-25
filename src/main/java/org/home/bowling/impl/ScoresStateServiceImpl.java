package org.home.bowling.impl;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.service.ArrayScoresCalculatorService;
import org.home.bowling.service.ScoresStateService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ScoresStateServiceImpl implements ScoresStateService {

    @EJB
    private ArrayScoresCalculatorService arrayScoresCalculatorService;


    @Override
    public void updateScoresState(List<CellWrapper> cellsWrappers, CurrentHitDto currentHitDto) {
        arrayScoresCalculatorService.recalculateArrayScores(cellsWrappers,currentHitDto);
    }
}
