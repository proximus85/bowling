package org.home.bowling.impl;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.ScoreCellAlgorithmWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategyPickerService;
import org.home.bowling.service.ScoresCalculationStrategyService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ScoresCalculationStrategyPickerServiceImpl implements ScoresCalculationStrategyPickerService {

    public static final int PINS_NUMBER = 10;
    public static final int ROUNDS_NUMBER = 10;

    @EJB(beanName = "StrikeScoresCalculationStrategyServiceImpl")
    private ScoresCalculationStrategyService strikeScoresCalculationStrategyServiceImpl;

    @EJB(beanName = "SpareCalculationServiceImpl")
    private ScoresCalculationStrategyService spareCalculationServiceImpl;

    @EJB(beanName = "AnzeigeCalculationStrategyServiceImpl")
    private ScoresCalculationStrategyService anzeigeCalculationStrategyServiceImpl;


    @Override
    public ScoresCalculationStrategyService pickScoresCalculationStrategy(List<ScoreCellAlgorithmWrapper> scoreCellDtoList,
                                                                          CurrentThrowDto currentThrowDto) {

        if (currentThrowDto.getPinsHited() == PINS_NUMBER && currentThrowDto.getRoundNumber() < ROUNDS_NUMBER) {
            return strikeScoresCalculationStrategyServiceImpl;
        }

        if (getScoresSumForCurrentRound(scoreCellDtoList, currentThrowDto) == PINS_NUMBER
                && currentThrowDto.getRoundNumber() < ROUNDS_NUMBER) {
            return spareCalculationServiceImpl;
        }

        return anzeigeCalculationStrategyServiceImpl;
    }

    private int getScoresSumForCurrentRound(List<ScoreCellAlgorithmWrapper> scoreCellDtoList,
                                            CurrentThrowDto currentThrowDto) {
        int totalScores = 0;
        ScoreCellDto scoreCellDto = scoreCellDtoList.get(currentThrowDto.getRoundNumber()).getScoreCellDto();

        for (Integer score : scoreCellDto.getScores()) {
            totalScores += score;
        }

        return totalScores;
    }
}
