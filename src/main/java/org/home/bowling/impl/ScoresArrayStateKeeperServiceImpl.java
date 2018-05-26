package org.home.bowling.impl;

import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.service.BowlingArrayInitializationService;
import org.home.bowling.service.PinsStateService;
import org.home.bowling.service.ScoresArrayStateKeeperService;
import org.home.bowling.service.ScoresStateService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ScoresArrayStateKeeperServiceImpl implements ScoresArrayStateKeeperService {

    @EJB
    private PinsStateService pinsStateService;

    @EJB
    private ScoresStateService scoresStateService;

    @EJB
    private BowlingArrayInitializationService bowlingArrayInitializationService;

    @Override
    public List<ScoreCellAlgorithmDto> getInitialScoresArrayState() {
        return bowlingArrayInitializationService.getInitializedBowlingArray();
    }

    @Override
    public void updateScores(List<ScoreCellAlgorithmDto> cellsWrappers, CurrentHitDto currentHitDto) {
        pinsStateService.updatePinsState(cellsWrappers, currentHitDto);
        scoresStateService.updateScoresState(cellsWrappers, currentHitDto);
    }
}
