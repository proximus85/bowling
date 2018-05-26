package org.home.bowling.impl;

import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.PinsStateService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PinsStateServiceImpl implements PinsStateService {

    @Override
    public void updatePinsState(List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtos, CurrentHitDto currentHitDto) {
        ScoreCellDto scoreCellDto = scoreCellAlgorithmDtos.get(currentHitDto.getRoundNumber()).getScoreCellDto();
        scoreCellDto.getHitPinsNumber().add(currentHitDto.getHitPinsNumber());
    }
}
