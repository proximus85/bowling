package org.home.bowling.impl;

import org.home.bowling.dto.HeatDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategyPickerService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ScoresCalculationStrategyPickerServiceImpl implements ScoresCalculationStrategyPickerService {

    @Override
    public ScoresCalculationStrategy pickScoresCalculationStrategy(List<ScoreCellDto> scoreCellDtoList,
                                                                   HeatDto scoreCellDto) {
        //TODO finish implementation
        throw new IllegalStateException("Operation not supported");
    }
}
