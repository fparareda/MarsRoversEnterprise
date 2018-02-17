package com.fparareda.charging.service;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;

public interface ChargingService {
    MarsRover chargeBateries(long marsRoverId, Boolean chargeBateries) throws EntityNotFoundException;
}
