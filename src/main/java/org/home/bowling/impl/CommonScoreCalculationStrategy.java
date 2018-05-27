package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.utils.ScoreCalculatorHelper;

import java.util.List;

public abstract class CommonScoreCalculationStrategy {

    protected List<ScoreCellAlgorithmDto> scoreCells;
    protected int cellIndex;

    Integer calculatePreviousCellScores() {
        if (cellIndex - 1 >= 0) {
            return scoreCells.get(cellIndex - 1).getScoreCellDto().getTotalScores();
        }
        return 0;
    }

    Integer calculateCurrentCellScores() {
        return ScoreCalculatorHelper.calculateTotalSum(scoreCells.get(cellIndex).getScoreCellDto().getHitPinsNumber());
    }

    abstract Integer calculateNextCellScores();

    void calculateCurrentRoundScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
        this.scoreCells = scoreCells;
        this.cellIndex = cellIndex;
        scoreCells.get(cellIndex).getScoreCellDto().setTotalScores(calculatePreviousCellScores() + calculateCurrentCellScores() + calculateNextCellScores());
    }
}
