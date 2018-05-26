package org.home.bowling;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.impl.StrikeScoresCalculationStrategyImpl;
import org.home.bowling.util.ScoresCalculationStrategyTestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StrikeScoresCalculationStrategyImplTest {

    private final int CELL_INDEX_WITH_STRIKE = 1;
    private StrikeScoresCalculationStrategyImpl strikeScoresCalculationStrategy;
    private List<ScoreCellAlgorithmDto> scoreCells;

    @Before
    public void setUp() {
        strikeScoresCalculationStrategy = new StrikeScoresCalculationStrategyImpl();
        scoreCells = ScoresCalculationStrategyTestUtils.createEmptyScoresArray();

        ScoreCellDto firstScoreCell = scoreCells.get(0).getScoreCellDto();
        firstScoreCell.setRoundNo(0);
        firstScoreCell.setHitPinsNumber(Arrays.asList(4, 3));
        firstScoreCell.setTotalScores(7);

        ScoreCellDto secondScoreCell = scoreCells.get(CELL_INDEX_WITH_STRIKE).getScoreCellDto();
        secondScoreCell.setRoundNo(CELL_INDEX_WITH_STRIKE);
        secondScoreCell.setHitPinsNumber(Arrays.asList(10, 0));
    }

    @Test
    public void shouldRecalculateTotalScoresForStrikeWhenNextCellIsEmpty() {
        //given
        int EXPECTED_TOTAL_SCORES = 17;

        //when
        strikeScoresCalculationStrategy.recalculateScores(scoreCells, CELL_INDEX_WITH_STRIKE);

        //then
        assertTrue(EXPECTED_TOTAL_SCORES == scoreCells.get(CELL_INDEX_WITH_STRIKE)
                .getScoreCellDto().getTotalScores());
    }

    @Test
    public void shouldAddOneHitPinsNumberAftertrike() {
        //given
        int EXPECTED_TOTAL_SCORES = 22;

        ScoreCellDto thirdScoreCell = scoreCells.get(CELL_INDEX_WITH_STRIKE + 1).getScoreCellDto();
        thirdScoreCell.setRoundNo(CELL_INDEX_WITH_STRIKE + 1);
        thirdScoreCell.setHitPinsNumber(Arrays.asList(5));

        //when
        strikeScoresCalculationStrategy.recalculateScores(scoreCells, CELL_INDEX_WITH_STRIKE);

        //then
        assertTrue(EXPECTED_TOTAL_SCORES == scoreCells.get(CELL_INDEX_WITH_STRIKE)
                .getScoreCellDto().getTotalScores());
    }

    @Test
    public void shouldAddTwoHitPinsNumberAfterStrike() {
        //given
        int EXPECTED_TOTAL_SCORES = 25;

        ScoreCellDto thirdScoreCell = scoreCells.get(CELL_INDEX_WITH_STRIKE + 1).getScoreCellDto();
        thirdScoreCell.setRoundNo(CELL_INDEX_WITH_STRIKE + 1);
        thirdScoreCell.setHitPinsNumber(Arrays.asList(5, 3));

        //when
        strikeScoresCalculationStrategy.recalculateScores(scoreCells, CELL_INDEX_WITH_STRIKE);

        //then
        assertTrue(EXPECTED_TOTAL_SCORES == scoreCells.get(CELL_INDEX_WITH_STRIKE)
                .getScoreCellDto().getTotalScores());
    }
}
