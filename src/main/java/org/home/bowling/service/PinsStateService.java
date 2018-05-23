package org.home.bowling.service;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.ScoreCellAlgorithmWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PinsStateService {
    void updatePinsState(List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers, CurrentThrowDto currentThrowDto);
}
