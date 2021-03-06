package org.home.bowling.service;

import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.ScoreCellAlgorithmDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategyPickerService {
    ScoresCalculationStrategy pickScoresCalculationStrategy(List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtos,
                                                            CurrentHitDto scoreCellDto);
}
