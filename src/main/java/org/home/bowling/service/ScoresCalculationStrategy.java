package org.home.bowling.service;

import org.home.bowling.dto.CellWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategy {
    CellWrapper recalculateScores(List<CellWrapper> scoreCells, int cellIndex);
}
