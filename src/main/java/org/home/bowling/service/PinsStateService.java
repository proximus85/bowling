package org.home.bowling.service;

import org.home.bowling.dto.CurrentThrowDto;
import org.home.bowling.dto.CellWrapper;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PinsStateService {
    void updatePinsState(List<CellWrapper> cellWrappers, CurrentThrowDto currentThrowDto);
}
