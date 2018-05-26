package org.home.bowling;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.impl.SpareCalculationImpl;
import org.home.bowling.util.ScoresCalculationStrategyTestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SpareCalculationImplTest {

    private SpareCalculationImpl spareCalculation;
    private List<ScoreCellAlgorithmDto> scoreCells;

    @Before
    public void setUp() {
        spareCalculation = new SpareCalculationImpl();
        scoreCells = ScoresCalculationStrategyTestUtils.createEmptyScoresArray();
    }

    @Test
    public void shouldRecalculateTotalScoresForSpareWhenNextCellIsEmpty() {
        //given
        int CELL_INDEX_WITH_SPARE = 1;
        int EXPECTED_TOTAL_SCORES = 17;

        ScoreCellDto firstScoreCell = scoreCells.get(0).getScoreCellDto();
        firstScoreCell.setRoundNo(0);
        firstScoreCell.setHitPinsNumber(Arrays.asList(4, 3));
        firstScoreCell.setTotalScores(7);

        ScoreCellDto secondScoreCell = scoreCells.get(CELL_INDEX_WITH_SPARE).getScoreCellDto();
        secondScoreCell.setRoundNo(1);
        secondScoreCell.setHitPinsNumber(Arrays.asList(4, 6));

        //when
        spareCalculation.recalculateScores(scoreCells, CELL_INDEX_WITH_SPARE);

        //then
        assertTrue(EXPECTED_TOTAL_SCORES == scoreCells.get(CELL_INDEX_WITH_SPARE)
                .getScoreCellDto().getTotalScores());
    }

    @Test
    public void shouldAddOneHitPinsNumberAfterSpare() {
        //given
        int CELL_INDEX_WITH_SPARE = 1;
        int EXPECTED_TOTAL_SCORES = 22;

        ScoreCellDto firstScoreCell = scoreCells.get(0).getScoreCellDto();
        firstScoreCell.setRoundNo(0);
        firstScoreCell.setHitPinsNumber(Arrays.asList(4, 3));
        firstScoreCell.setTotalScores(7);

        ScoreCellDto secondScoreCell = scoreCells.get(CELL_INDEX_WITH_SPARE).getScoreCellDto();
        secondScoreCell.setRoundNo(CELL_INDEX_WITH_SPARE);
        secondScoreCell.setHitPinsNumber(Arrays.asList(4, 6));

        ScoreCellDto thirdScoreCell = scoreCells.get(CELL_INDEX_WITH_SPARE + 1).getScoreCellDto();
        thirdScoreCell.setRoundNo(CELL_INDEX_WITH_SPARE + 1);
        thirdScoreCell.setHitPinsNumber(Arrays.asList(5));

        //when
        spareCalculation.recalculateScores(scoreCells, CELL_INDEX_WITH_SPARE);

        //then
        assertTrue(EXPECTED_TOTAL_SCORES == scoreCells.get(CELL_INDEX_WITH_SPARE)
                .getScoreCellDto().getTotalScores());
    }

    @Test
    public void shouldNotAddTwoHitPinsNumberAfterSpare() {
        //given
        int CELL_INDEX_WITH_SPARE = 1;
        int EXPECTED_TOTAL_SCORES = 22;

        ScoreCellDto firstScoreCell = scoreCells.get(0).getScoreCellDto();
        firstScoreCell.setRoundNo(0);
        firstScoreCell.setHitPinsNumber(Arrays.asList(4, 3));
        firstScoreCell.setTotalScores(7);

        ScoreCellDto secondScoreCell = scoreCells.get(CELL_INDEX_WITH_SPARE).getScoreCellDto();
        secondScoreCell.setRoundNo(CELL_INDEX_WITH_SPARE);
        secondScoreCell.setHitPinsNumber(Arrays.asList(4, 6));

        ScoreCellDto thirdScoreCell = scoreCells.get(CELL_INDEX_WITH_SPARE + 1).getScoreCellDto();
        thirdScoreCell.setRoundNo(CELL_INDEX_WITH_SPARE + 1);
        thirdScoreCell.setHitPinsNumber(Arrays.asList(5, 3));

        //when
        spareCalculation.recalculateScores(scoreCells, CELL_INDEX_WITH_SPARE);

        //then
        assertTrue(EXPECTED_TOTAL_SCORES == scoreCells.get(CELL_INDEX_WITH_SPARE)
                .getScoreCellDto().getTotalScores());
    }
}
