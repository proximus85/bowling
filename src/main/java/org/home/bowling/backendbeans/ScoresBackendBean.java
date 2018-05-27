package org.home.bowling.backendbeans;

import lombok.Getter;
import lombok.Setter;
import org.home.bowling.dto.CurrentHitDto;
import org.home.bowling.dto.ScoreCellAlgorithmDto;
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
    private List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtos;

    public Integer getHitedPinsNumber() {
        return hitedPinsNumber;
    }

    public void setHitedPinsNumber(Integer hitedPinsNumber) {
        this.hitedPinsNumber = hitedPinsNumber;
    }

    @PostConstruct
    void initializeScoresArray() {
        setScoresArrayToInitialState();
    }

    public void reset() {
        setScoresArrayToInitialState();
    }

    private void setScoresArrayToInitialState() {
        scoreCellAlgorithmDtos = scoresArrayStateKeeperService.getInitialScoresArrayState();
        scores = scoresCellMapper.mapToDto(scoreCellAlgorithmDtos);
        counter = 0;
        roundNumber = 0;
        hitNumber = 0;
        result = 0;
    }

    public void updateBowlingArray() {
        if (counter < 21) {
            CurrentHitDto currentHitDto = new CurrentHitDto(roundNumber, hitNumber, hitedPinsNumber);
            scoresArrayStateKeeperService.updateScores(scoreCellAlgorithmDtos, currentHitDto);
            scores = scoresCellMapper.mapToDto(scoreCellAlgorithmDtos);
            if (counter == 20) {
                result = scores.get(scores.size() - 1).getTotalScores();
            }
            counter++;
            updateHitNumber();
            updateRoundNumber();
        }
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
