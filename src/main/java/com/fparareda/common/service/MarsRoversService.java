package com.fparareda.common.service;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;

public interface MarsRoversService {

    MarsRover find(Long marsRoverId)  throws EntityNotFoundException;

    MarsRover save(MarsRover marsRovers);
}
