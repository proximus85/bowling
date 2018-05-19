package org.home.bowling.impl;

import org.home.bowling.dto.HeatDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoreArrayManagerService;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
public class ScoreArrayManagerServiceImpl implements ScoreArrayManagerService {

    public static final int SCORES_ARRAY_LENGTH = 10;
    public static final int INITIAL_TOTAL_SCORES = 10;

    @Override
    public List<ScoreCellDto> getInitialScoresArrayState() {
        List<ScoreCellDto> scores = new ArrayList<>();
        for (int i = 1; i <= SCORES_ARRAY_LENGTH; i++) {
            ScoreCellDto scoreCellDto = ScoreCellDto.builder()
                    .roundNo(i)
                    .scores(Arrays.asList(1, 2))
                    .totalScores(INITIAL_TOTAL_SCORES)
                    .build();

            scores.add(scoreCellDto);
        }
        return scores;
    }

    @Override
    public List<ScoreCellDto> recalculatePoints(List<ScoreCellDto> scores, HeatDto heatDto) {
        ScoreCellDto scoreCellDto = scores.get(heatDto.getRoundNumber());
        scoreCellDto.getScores().set(heatDto.getHeatNumber(), heatDto.getPinsHeated());
        return scores;
    }
}
