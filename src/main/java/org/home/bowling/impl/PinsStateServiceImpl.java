package org.home.bowling.impl;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.ScoreCellAlgorithmWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.PinsStateService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PinsStateServiceImpl implements PinsStateService {

    @Override
    public void updatePinsState(List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers, CurrentThrowDto currentThrowDto) {
        ScoreCellDto scoreCellDto = scoreCellAlgorithmWrappers.get(currentThrowDto.getRoundNumber()).getScoreCellDto();
        scoreCellDto.getScores().add(currentThrowDto.getPinsHited());
    }
}
