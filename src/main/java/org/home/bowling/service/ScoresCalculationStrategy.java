package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellAlgorithmDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategy {
    ScoreCellAlgorithmDto recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex);
}
