package org.home.bowling.backendbeans;

import lombok.Getter;
import lombok.Setter;
import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.ScoreCellAlgorithmWrapper;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.impl.RandomPointsGeneratorServiceImpl;
import org.home.bowling.mapper.ScoresCellMapper;
import org.home.bowling.service.ScoresArrayStateKeeperService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
@Setter
@Getter
public class ScoresBackendBean {

    public static final Integer MAX_NUMBER_OF_PINS = 10;

    @EJB
    private ScoresArrayStateKeeperService scoresArrayStateKeeperService;

    @EJB
    private RandomPointsGeneratorServiceImpl randomPointsGeneratorService;

    @EJB
    private ScoresCellMapper scoresCellMapper;

    private List<ScoreCellDto> scores;

    private Integer roundNumber = 0;
    private Integer hitNumber = 0;
    private Integer hitedPinsNumber;
    private Integer counter = 0;
    private Integer result = 0;
    private List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers;

    public Integer getHitedPinsNumber() {
        return hitedPinsNumber;
    }

    public void setHitedPinsNumber(Integer hitedPinsNumber) {
        this.hitedPinsNumber = hitedPinsNumber;
    }

    @PostConstruct
    void initializeScoresArray() {
        scoreCellAlgorithmWrappers = scoresArrayStateKeeperService.getInitialScoresArrayState();
        scores = scoresCellMapper.mapToDto(scoreCellAlgorithmWrappers);
    }

    public void updateBowlingArray() {
        if (counter < 21) {
            CurrentThrowDto currentThrowDto = new CurrentThrowDto(roundNumber, hitNumber, hitedPinsNumber);
            scoreCellAlgorithmWrappers = scoresArrayStateKeeperService.updateScores(scoreCellAlgorithmWrappers, currentThrowDto);
            scores = scoresCellMapper.mapToDto(scoreCellAlgorithmWrappers);
            counter++;
            updateHitNumber();
            updateRoundNumber();
            if (counter == 20) {
                result = calculateResult(scores);
            }
        }
    }

    private Integer calculateResult(List<ScoreCellDto> scores) {
        Integer result = 0;
        for (ScoreCellDto score : scores) {//TODO move to service
            result += score.getTotalScores();
        }
        return result;
    }

    private void updateHitNumber() {
        if (roundNumber == 9) {
            hitNumber = ++hitNumber % 3;
        } else {
            hitNumber = ++hitNumber % 2;
        }
    }

    private void updateRoundNumber() {
        if (counter % 2 == 0 && roundNumber < 9) {
            roundNumber++;
        }
        if (counter > 18 && roundNumber < 9) {
            roundNumber = 10;//TODO sux rmove
        }
    }

    public List<ScoreCellDto> getScores() {
        return scores;
    }
}
