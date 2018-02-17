package com.fparareda.common.service.impl;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;
import com.fparareda.common.repository.MarsRoversRepository;
import com.fparareda.common.service.MarsRoversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarsRoversServiceImpl implements MarsRoversService {

    private MarsRoversRepository marsRoversRepository;

    @Autowired
    public MarsRoversServiceImpl(MarsRoversRepository marsRoversRepository) {
        this.marsRoversRepository = marsRoversRepository;
    }

    @Override
    public MarsRover find(Long marsRoverId) throws EntityNotFoundException {
        MarsRover marsRovers = marsRoversRepository.findOne(marsRoverId);
        if (marsRovers == null) {
            throw new EntityNotFoundException("Could not find entity with id: " + marsRoverId);
        }
        return marsRovers;
    }

    @Override
    public MarsRover save(MarsRover marsRovers) {
        return marsRoversRepository.save(marsRovers);
    }
}
