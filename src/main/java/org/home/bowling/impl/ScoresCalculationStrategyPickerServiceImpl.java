package org.home.bowling.impl;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategyPickerService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ScoresCalculationStrategyPickerServiceImpl implements ScoresCalculationStrategyPickerService {

    public static final int PINS_NUMBER = 10;
    public static final int ROUNDS_NUMBER = 10;

    @EJB(beanName = "StrikeScoresCalculationStrategyImpl")
    private ScoresCalculationStrategy strikeScoresCalculationStrategyImpl;

    @EJB(beanName = "SpareCalculationImpl")
    private ScoresCalculationStrategy spareCalculationServiceImpl;

    @EJB(beanName = "AnzeigeCalculationStrategyImpl")
    private ScoresCalculationStrategy anzeigeCalculationStrategyServiceImpl;


    @Override
    public ScoresCalculationStrategy pickScoresCalculationStrategy(List<ScoreCellAlgorithmDto> scoreCellDtoList,
                                                                   CurrentHitDto currentHitDto) {

        if (currentHitDto.getHitPinsNumber() == PINS_NUMBER && currentHitDto.getRoundNumber() < ROUNDS_NUMBER) {
            return strikeScoresCalculationStrategyImpl;
        }

        if (getScoresSumForCurrentRound(scoreCellDtoList, currentHitDto) == PINS_NUMBER
                && currentHitDto.getRoundNumber() < ROUNDS_NUMBER) {
            return spareCalculationServiceImpl;
        }

        return anzeigeCalculationStrategyServiceImpl;
    }

    private int getScoresSumForCurrentRound(List<ScoreCellAlgorithmDto> scoreCellDtoList, CurrentHitDto currentHitDto) {
        int totalScores = 0;
        ScoreCellDto scoreCellDto = scoreCellDtoList.get(currentHitDto.getRoundNumber()).getScoreCellDto();
        for (Integer score : scoreCellDto.getScores()) {
            totalScores += score;
        }
        return totalScores;
    }
}
