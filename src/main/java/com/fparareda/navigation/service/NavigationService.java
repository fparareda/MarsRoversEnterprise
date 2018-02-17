package com.fparareda.navigation.service;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;
import com.fparareda.common.model.Position;

public interface NavigationService {
    MarsRover move(Long marsRoverId, Position position) throws EntityNotFoundException;
}
