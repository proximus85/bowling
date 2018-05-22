package org.home.bowling.impl;

import org.home.bowling.dto.HeatDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategyPickerService;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Stateless;

@Stateless
public class ScoresCalculationStrategyPickerServiceImpl implements ScoresCalculationStrategyPickerService {

    @Override
    public ScoresCalculationStrategy pickScoresCalculationStrategy(ScoreCellAlgorithmWrapper scoreCellDtoList,
                                                                   HeatDto scoreCellDto) {
        //TODO finish implementation
        throw new IllegalStateException("Operation not supported");
    }
}
