package org.home.bowling.util;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.impl.DefaultScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoresCalculationStrategyTestUtils {

    private static final int INITIAL_TOTAL_SCORES = 0;
    private static final int ROUNDS_NUMBER = 10;

    public static List<ScoreCellAlgorithmDto> createEmptyScoresArray() {
        List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtos = new ArrayList<>();
        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            ScoreCellDto scoreCellDto = new ScoreCellDto(i, Collections.emptyList(), INITIAL_TOTAL_SCORES);
            ScoresCalculationStrategy scoresCalculationStrategy = new DefaultScoresCalculationStrategy();
            ScoreCellAlgorithmDto scoreCellAlgorithmDto =
                    new ScoreCellAlgorithmDto(scoreCellDto, scoresCalculationStrategy);
            scoreCellAlgorithmDtos.add(scoreCellAlgorithmDto);
        }
        return scoreCellAlgorithmDtos;
    }


}