package org.home.bowling.service;

import org.home.bowling.dto.HeatDto;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Local;

@Local
public interface ScoresCalculationStrategyPickerService {
    ScoresCalculationStrategy pickScoresCalculationStrategy(ScoreCellAlgorithmWrapper scoreCellDtoList, HeatDto scoreCellDto);
}
