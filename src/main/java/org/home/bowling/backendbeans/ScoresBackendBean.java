package org.home.bowling.backendbeans;

import lombok.Getter;
import lombok.Setter;
import org.home.bowling.dto.HeatDto;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.impl.RandomPointsGeneratorServiceImpl;
import org.home.bowling.service.ScoreArrayManagerService;

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
    private ScoreArrayManagerService scoreArrayManagerService;

    @EJB
    private RandomPointsGeneratorServiceImpl randomPointsGeneratorService;

    private List<ScoreCellDto> scores;

    @PostConstruct
    void initializeScoresArray() {
        scores = scoreArrayManagerService.getInitialScoresArrayState();
    }

    public void addScores() {
        Integer roundNumber = 3;
        Integer heatNumber = 1;

        //TODO move to some state holder

        Integer pinsHeated = randomPointsGeneratorService.getRandomNumber(MAX_NUMBER_OF_PINS);
        HeatDto heatDto = new HeatDto(roundNumber, heatNumber, pinsHeated);
        scores = scoreArrayManagerService.recalculatePoints(scores, heatDto);
    }

    public List<ScoreCellDto> getScores() {
        return scores;
    }
}
