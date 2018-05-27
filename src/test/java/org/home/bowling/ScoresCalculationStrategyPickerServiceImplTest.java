package org.home.bowling;

import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.impl.AnzeigeCalculationStrategy;
import org.home.bowling.impl.ScoresCalculationStrategyPickerServiceImpl;
import org.home.bowling.impl.SpareCalculationStrategy;
import org.home.bowling.impl.StrikeCalculationStrategy;
import org.home.bowling.service.ScoresCalculationStrategy;
import org.home.bowling.util.ScoresCalculationStrategyTestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ScoresCalculationStrategyPickerServiceImplTest {

    public static final int PINS_NUMBER = 10;
    private ScoresCalculationStrategyPickerServiceImpl scoresCalculationStrategyPickerService;
    private List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtoList;

    @Before
    public void setUp() {
        ScoresCalculationStrategy strikeScoresCalculationStrategyImpl = new StrikeCalculationStrategy();
        ScoresCalculationStrategy spareCalculationServiceImpl = new SpareCalculationStrategy();
        ScoresCalculationStrategy anzeigeCalculationStrategyServiceImpl = new AnzeigeCalculationStrategy();

        scoresCalculationStrategyPickerService = new ScoresCalculationStrategyPickerServiceImpl();
        scoresCalculationStrategyPickerService.setAnzeigeCalculationStrategy(anzeigeCalculationStrategyServiceImpl);
        scoresCalculationStrategyPickerService.setSpareCalculationStrategy(spareCalculationServiceImpl);
        scoresCalculationStrategyPickerService.setStrikeCalculationStrategy(strikeScoresCalculationStrategyImpl);

        scoreCellAlgorithmDtoList = ScoresCalculationStrategyTestUtils.createEmptyScoresArray();
    }

    @Test
    public void shouldPickAnzeigeCalculationStrategy() {
        //given
        int roundNumber = 0;
        int hitNumber = 0;
        int hitPinsNumber = 0;

        CurrentHitDto currentHitDto = new CurrentHitDto(roundNumber, hitNumber, hitPinsNumber);

        //when
        ScoresCalculationStrategy actualStrategy = scoresCalculationStrategyPickerService
                .pickScoresCalculationStrategy(scoreCellAlgorithmDtoList, currentHitDto);
        //then
        assertTrue(actualStrategy instanceof AnzeigeCalculationStrategy);
    }

    @Test
    public void shouldPickStrikeCalculationStrategy() {
        //given
        int roundNumber = 0;
        int hitNumber = 0;
        int hitPinsNumber = 10;

        CurrentHitDto currentHitDto = new CurrentHitDto(roundNumber, hitNumber, hitPinsNumber);

        //when
        ScoresCalculationStrategy actualStrategy = scoresCalculationStrategyPickerService
                .pickScoresCalculationStrategy(scoreCellAlgorithmDtoList, currentHitDto);
        //then
        assertTrue(actualStrategy instanceof StrikeCalculationStrategy);
    }

    @Test
    public void shouldPickSpareCalculationStrategy() {
        //given
        int roundNumber = 0;
        int hitNumber = 1;
        int hitPinsNumber = 3;

        CurrentHitDto currentHitDto = new CurrentHitDto(roundNumber, hitNumber, hitPinsNumber);

        ScoreCellDto scoreCellDto = scoreCellAlgorithmDtoList.get(0).getScoreCellDto();
        scoreCellDto.setRoundNo(0);
        scoreCellDto.setHitPinsNumber(Arrays.asList(PINS_NUMBER - hitPinsNumber, hitPinsNumber));

        //when
        ScoresCalculationStrategy actualStrategy = scoresCalculationStrategyPickerService
                .pickScoresCalculationStrategy(scoreCellAlgorithmDtoList, currentHitDto);
        //then
        assertTrue(actualStrategy instanceof SpareCalculationStrategy);
    }

    @Test
    public void shouldLeaveStrikeCalculationStrategy() {
        //given
        int roundNumber = 0;
        int hitNumber = 1;
        int hitPinsNumber = 0;

        CurrentHitDto currentHitDto = new CurrentHitDto(roundNumber, hitNumber, hitPinsNumber);

        ScoreCellDto scoreCellDto = scoreCellAlgorithmDtoList.get(0).getScoreCellDto();
        scoreCellDto.setRoundNo(0);
        scoreCellDto.setHitPinsNumber(Arrays.asList(PINS_NUMBER));

        //when
        ScoresCalculationStrategy actualStrategy = scoresCalculationStrategyPickerService
                .pickScoresCalculationStrategy(scoreCellAlgorithmDtoList, currentHitDto);
        //then
        assertTrue(actualStrategy instanceof StrikeCalculationStrategy);
    }
}
