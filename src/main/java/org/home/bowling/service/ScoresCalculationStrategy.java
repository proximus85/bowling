package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellAlgorithmDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategy {
    void recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex);
}
