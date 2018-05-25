package org.home.bowling.service;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.CellWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresArrayStateKeeperService {
    List<CellWrapper> getInitialScoresArrayState();

    void updateScores(List<CellWrapper> scores, CurrentThrowDto currentThrowDto);
}
