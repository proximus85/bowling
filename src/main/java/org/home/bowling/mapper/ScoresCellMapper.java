package org.home.bowling.mapper;

import org.home.bowling.dto.ScoreCellAlgorithmDto;
import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScoresCellMapper {

    public List<ScoreCellDto> mapToDto(List<ScoreCellAlgorithmDto> scoreCellAlgorithmDtos) {
        List<ScoreCellDto> scoreCellDtos = new ArrayList<>();

        for (ScoreCellAlgorithmDto scoreCellAlgorithmDto : scoreCellAlgorithmDtos) {
            scoreCellDtos.add(scoreCellAlgorithmDto.getScoreCellDto());
        }

        return scoreCellDtos;
    }
}
