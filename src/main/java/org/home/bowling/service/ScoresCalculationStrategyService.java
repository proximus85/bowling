package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellAlgorithmWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategyService {
    ScoreCellAlgorithmWrapper recalculateScores(List<ScoreCellAlgorithmWrapper> scoreCells, int cellIndex);
}
