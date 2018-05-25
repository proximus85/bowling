package org.home.bowling.service;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.CurrentHitDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresStateService {
    void updateScoresState(List<CellWrapper> cellsWrappers, CurrentHitDto currentHitDto);
}

