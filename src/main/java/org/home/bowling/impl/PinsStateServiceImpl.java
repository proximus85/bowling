package org.home.bowling.impl;

import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.PinsStateService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PinsStateServiceImpl implements PinsStateService {

    @Override
    public void updatePinsState(List<CellWrapper> cellWrappers, CurrentHitDto currentHitDto) {
        ScoreCellDto scoreCellDto = cellWrappers.get(currentHitDto.getRoundNumber()).getScoreCellDto();
        scoreCellDto.getScores().add(currentHitDto.getPinsHited());
    }
}
