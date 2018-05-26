package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.CurrentHitDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresStateService {
    void updateScoresState(List<ScoreCellAlgorithmDto> cellsWrappers, CurrentHitDto currentHitDto);
}

