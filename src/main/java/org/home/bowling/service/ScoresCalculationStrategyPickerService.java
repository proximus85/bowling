package org.home.bowling.service;

import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.CellWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategyPickerService {
    ScoresCalculationStrategy pickScoresCalculationStrategy(List<CellWrapper> cellWrappers,
                                                            CurrentHitDto scoreCellDto);
}
