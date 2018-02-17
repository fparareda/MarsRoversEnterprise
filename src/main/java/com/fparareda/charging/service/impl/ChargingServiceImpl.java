package com.fparareda.charging.service.impl;

import com.fparareda.charging.service.ChargingService;
import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;
import com.fparareda.common.service.MarsRoversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargingServiceImpl implements ChargingService{

    private MarsRoversService marsRoversService;

    @Autowired
    public ChargingServiceImpl(MarsRoversService marsRoversService) {
        this.marsRoversService = marsRoversService;
    }


    @Override
    public MarsRover chargeBateries(long marsRoverId, Boolean chargeBateries) throws EntityNotFoundException {
        MarsRover marsRover = marsRoversService.find(marsRoverId);
        marsRover.chargeBateries(chargeBateries);
        return marsRoversService.save(marsRover);
    }
}
