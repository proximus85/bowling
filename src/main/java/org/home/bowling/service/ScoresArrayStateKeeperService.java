package org.home.bowling.service;

import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.CellWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresArrayStateKeeperService {
    List<CellWrapper> getInitialScoresArrayState();

    void updateScores(List<CellWrapper> scores, CurrentHitDto currentHitDto);
}
