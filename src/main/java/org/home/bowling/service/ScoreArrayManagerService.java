package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ScoreArrayManagerService {

    List<ScoreCellDto> getInitialScoresArrayState();

}
