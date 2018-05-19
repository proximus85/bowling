package org.home.bowling.backendbeans;

import lombok.Getter;
import lombok.Setter;
import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.service.ScoreArrayManagerService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class ScoresBackendBean {

    @EJB
    private ScoreArrayManagerService scoreArrayManagerService;

    private List<ScoreCellDto> scores;

    @PostConstruct
    void initializeScoresArray() {
        scores = scoreArrayManagerService.getInitialScoresArrayState();
    }
}
