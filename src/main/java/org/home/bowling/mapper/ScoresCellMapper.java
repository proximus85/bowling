package org.home.bowling.mapper;

import org.home.bowling.dto.CellWrapper;
import org.home.bowling.dto.ScoreCellDto;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScoresCellMapper {

    public List<ScoreCellDto> mapToDto(List<CellWrapper> cellWrappers) {
        List<ScoreCellDto> scoreCellDtos = new ArrayList<>();

        for (CellWrapper cellWrapper : cellWrappers) {
            scoreCellDtos.add(cellWrapper.getScoreCellDto());
        }

        return scoreCellDtos;
    }
}
