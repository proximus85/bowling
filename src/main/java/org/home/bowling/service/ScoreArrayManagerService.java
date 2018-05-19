package org.home.bowling.service;

import org.home.bowling.dto.HeatDto;
import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Remote;
import java.util.List;

@Remote//TODO check if possible to switch to @Local
public interface ScoreArrayManagerService {

    List<ScoreCellDto> getInitialScoresArrayState();

    List<ScoreCellDto> recalculatePoints(List<ScoreCellDto> scores, HeatDto heatDto);
}
