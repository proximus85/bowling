package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ScoresCalculatorService {
    void setScoresCells(List<ScoreCellDto> scoresCells);

    List<ScoreCellDto> calculateScores(ScoresCalculationStrategy scoresCalculationStrategy);
}

