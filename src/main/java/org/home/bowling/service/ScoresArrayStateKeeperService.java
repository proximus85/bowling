package org.home.bowling.service;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.ScoreCellAlgorithmWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresArrayStateKeeperService {
    List<ScoreCellAlgorithmWrapper> getInitialScoresArrayState();

    List<ScoreCellAlgorithmWrapper> updateScores(List<ScoreCellAlgorithmWrapper> scores, CurrentThrowDto currentThrowDto);
}
