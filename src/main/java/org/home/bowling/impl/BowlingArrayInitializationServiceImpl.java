package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.BowlingArrayInitializationService;
import org.home.bowling.service.ScoresCalculationStrategy;

import java.util.ArrayList;
import java.util.List;

public class BowlingArrayInitializationServiceImpl implements BowlingArrayInitializationService {

    private static final int SCORES_ARRAY_LENGTH = 10;

    @Override
    public List<ScoreCellAlgorithmDto> getInitializedBowlingArray() {

        List<ScoreCellAlgorithmDto> scores = new ArrayList<>();
        for (int i = 0; i < SCORES_ARRAY_LENGTH; i++) {

            ScoreCellDto scoreCellDto = new ScoreCellDto(i, new ArrayList<>(), 0);

            ScoreCellAlgorithmDto scoreCellAlgorithmDto = ScoreCellAlgorithmDto.builder()
                    .scoreCellDto(scoreCellDto)
                    .scoresCalculationStrategy(new ScoresCalculationStrategy() {
                        @Override
                        public ScoreCellAlgorithmDto recalculateScores(List<ScoreCellAlgorithmDto> scoreCells, int cellIndex) {
                            return scoreCells.get(cellIndex);
                        }
                    })
                    .build();
            scores.add(scoreCellAlgorithmDto);
        }
        return scores;
    }
}