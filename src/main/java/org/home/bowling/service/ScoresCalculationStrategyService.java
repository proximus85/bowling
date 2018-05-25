package org.home.bowling.service;

import org.home.bowling.dto.CellWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculationStrategyService {//TODO rename to ScoresCalculation
    CellWrapper recalculateScores(List<CellWrapper> scoreCells, int cellIndex);
}
