package org.home.bowling.service;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.ScoreCellAlgorithmWrapper;
import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresArrayStateKeeperService {
    List<ScoreCellDto> getInitialScoresArrayState();

    List<ScoreCellAlgorithmWrapper> updateScores(List<ScoreCellAlgorithmWrapper> scores, CurrentThrowDto currentThrowDto);
}
