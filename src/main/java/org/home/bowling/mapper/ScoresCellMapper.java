package org.home.bowling.mapper;

import org.home.bowling.dto.ScoreCellDto;
import org.home.bowling.util.ScoreCellAlgorithmWrapper;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScoresCellMapper {

    public List<ScoreCellDto> mapToDto(List<ScoreCellAlgorithmWrapper> scoreCellAlgorithmWrappers) {
        List<ScoreCellDto> scoreCellDtos = new ArrayList<>();

        for (ScoreCellAlgorithmWrapper scoreCellAlgorithmWrapper : scoreCellAlgorithmWrappers) {
            scoreCellDtos.add(scoreCellAlgorithmWrapper.getScoreCellDto());
        }

        return scoreCellDtos;
    }
}
