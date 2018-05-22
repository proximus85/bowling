package org.home.bowling.service;

import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategy {
    ScoreCellAlgorithmWrapper recalculateScores(List<ScoreCellAlgorithmWrapper> scoreCells);
}
