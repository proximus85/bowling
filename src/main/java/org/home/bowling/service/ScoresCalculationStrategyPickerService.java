package org.home.bowling.service;

import org.home.bowling.dto.HeatDto;
import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategyPickerService {
    ScoresCalculationStrategy pickScoresCalculationStrategy(List<ScoreCellDto> scoreCellDtoList, HeatDto scoreCellDto);
}
