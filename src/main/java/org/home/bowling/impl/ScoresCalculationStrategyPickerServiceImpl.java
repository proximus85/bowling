package org.home.bowling.impl;

import lombok.Setter;
import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategyPickerService;
import org.home.bowling.utils.ScoreCalculatorHelper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Setter
@Stateless
public class ScoresCalculationStrategyPickerServiceImpl implements ScoresCalculationStrategyPickerService {

    public static final int PINS_NUMBER = 10;
    public static final int ROUNDS_NUMBER = 10;

    @EJB(beanName = "StrikeCalculationStrategy")
    private ScoresCalculationStrategy strikeCalculationStrategy;

    @EJB(beanName = "SpareCalculationStrategy")
    private ScoresCalculationStrategy spareCalculationStrategy;

    @EJB(beanName = "AnzeigeCalculationStrategy")
    private ScoresCalculationStrategy anzeigeCalculationStrategy;


    @Override
    public ScoresCalculationStrategy pickScoresCalculationStrategy(List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtos,
                                                                   CurrentHitDto currentHitDto) {

        validateInput(scoreCellAlgorithmDtos, currentHitDto);
        //TODO rename if to prediacte functions names
        if ((currentHitDto.getHitPinsNumber() == PINS_NUMBER ||
                isMaxPinNumberHited(scoreCellAlgorithmDtos, currentHitDto))
                && currentHitDto.getRoundNumber() < ROUNDS_NUMBER) {

            return strikeCalculationStrategy;
        }

        if (currentHitDto.getHitPinsNumber() == PINS_NUMBER && currentHitDto.getRoundNumber() < ROUNDS_NUMBER) {
            return strikeCalculationStrategy;
        }

        if (getScoresSumForCurrentRound(scoreCellAlgorithmDtos, currentHitDto) == PINS_NUMBER
                && currentHitDto.getRoundNumber() < ROUNDS_NUMBER) {
            return spareCalculationStrategy;
        }

        return anzeigeCalculationStrategy;
    }

    private boolean isMaxPinNumberHited(List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtos, CurrentHitDto currentHitDto) {
        ScoreCellDto scoreCellDto = scoreCellAlgorithmDtos.get(currentHitDto.getRoundNumber()).getScoreCellDto();
        if (scoreCellDto.getHitPinsNumber().size() >= 1 && scoreCellDto.getHitPinsNumber().get(0) == PINS_NUMBER) {
            return true;
        }
        return false;
    }

    private void validateInput(List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtos, CurrentHitDto currentHitDto) {
        List<Integer> hitPinsNumbers = scoreCellAlgorithmDtos.get(currentHitDto.getRoundNumber())
                .getScoreCellDto().getHitPinsNumber();

        if (ScoreCalculatorHelper.calculateTotalSum(hitPinsNumbers) > PINS_NUMBER) {
            throw new IllegalStateException(String.format("Sum of hit pins cannot be bigger than %s.", PINS_NUMBER));
        }
    }

    private int getScoresSumForCurrentRound(List<ScoreCellAlgorithmDto> scoreCellDtoList, CurrentHitDto currentHitDto) {
        int totalScores = 0;
        ScoreCellDto scoreCellDto = scoreCellDtoList.get(currentHitDto.getRoundNumber()).getScoreCellDto();
        for (Integer score : scoreCellDto.getHitPinsNumber()) {
            totalScores += score;
        }
        return totalScores;
    }
}
