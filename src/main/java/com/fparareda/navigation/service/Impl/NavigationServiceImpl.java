package com.fparareda.navigation.service.Impl;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;
import com.fparareda.common.model.Position;
import com.fparareda.common.service.MarsRoversService;
import com.fparareda.navigation.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavigationServiceImpl implements NavigationService {

    private MarsRoversService marsRoversService;

    @Autowired
    public NavigationServiceImpl(MarsRoversService marsRoversService) {
        this.marsRoversService = marsRoversService;
    }

    @Override
    public MarsRover move(Long marsRoverId, Position position) throws EntityNotFoundException {
        MarsRover marsRovers = marsRoversService.find(marsRoverId);
        marsRovers.move(position);
        return marsRoversService.save(marsRovers);
    }

}
