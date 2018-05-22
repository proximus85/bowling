package org.home.bowling.backendbeans;

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
public class ScoresBackendBean {

    public static final Integer MAX_NUMBER_OF_PINS = 10;

    @EJB
    private ScoresArrayStateKeeperService scoresArrayStateKeeperService;

    @EJB
    private RandomPointsGeneratorServiceImpl randomPointsGeneratorService;

    @EJB
    private ScoresCellMapper scoresCellMapper;

    private List<ScoreCellDto> scores;

    private List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers;

    @PostConstruct
    void initializeScoresArray() {
        scores = scoresArrayStateKeeperService.getInitialScoresArrayState();
    }

    public void addScores() {
        //TODO pass parameters from WEB
        Integer roundNumber = 3;
        Integer heatNumber = 1;
        Integer pinsHeated = randomPointsGeneratorService.getRandomNumber(MAX_NUMBER_OF_PINS);

        CurrentThrowDto currentThrowDto = new CurrentThrowDto(roundNumber, heatNumber, pinsHeated);
        scoreCellAlgorithmWrappers = scoresArrayStateKeeperService.updateScores(scoreCellAlgorithmWrappers, currentThrowDto);
        scores = scoresCellMapper.mapToDto(scoreCellAlgorithmWrappers);
    }

    public List<ScoreCellDto> getScores() {
        return scores;
    }
}
