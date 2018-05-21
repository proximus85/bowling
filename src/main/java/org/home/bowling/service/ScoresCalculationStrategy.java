package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategy {
    List<ScoreCellDto> recalculateScores(List<ScoreCellDto> scoreCells);
}
