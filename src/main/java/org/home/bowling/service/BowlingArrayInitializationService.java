package org.home.bowling.service;

import org.home.bowling.dto.ScoreCellAlgorithmDto;

import java.util.List;

public interface BowlingArrayInitializationService {
    List<ScoreCellAlgorithmDto> getInitializedBowlingArray();
}
