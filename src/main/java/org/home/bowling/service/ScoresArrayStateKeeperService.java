package org.home.bowling.service;

import org.home.bowling.dto.HeatDto;
import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresArrayStateKeeperService {
    List<ScoreCellDto> getInitialScoresArrayState();

    List<ScoreCellDto> updateScores(List<ScoreCellDto> scores, HeatDto heatDto);
}
