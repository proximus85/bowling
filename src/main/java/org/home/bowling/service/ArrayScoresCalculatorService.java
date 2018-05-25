package org.home.bowling.service;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.CurrentHitDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ArrayScoresCalculatorService {

    void recalculateArrayScores(List<CellWrapper> cellsWrappers, CurrentHitDto currentHitDto);
}

