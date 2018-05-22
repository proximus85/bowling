package org.home.bowling.service;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategyPickerService {
    ScoresCalculationStrategy pickScoresCalculationStrategy(List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers, CurrentThrowDto scoreCellDto);
}
