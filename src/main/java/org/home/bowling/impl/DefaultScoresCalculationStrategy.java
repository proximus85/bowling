package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DefaultScoresCalculationStrategy implements ScoresCalculationStrategy {
    @Override
    public void recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
        new ScoresCalculationStrategy() {
            @Override
            public void recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
                ScoreCellDto scoreCellDto = scoreCells.get(cellIndex).getScoreCellDto();
                scoreCellDto.setTotalScores(scoreCellDto.getTotalScores());
            }
        };
    }
}
