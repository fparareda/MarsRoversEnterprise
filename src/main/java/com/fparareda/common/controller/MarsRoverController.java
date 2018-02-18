package com.fparareda.common.controller;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;
import com.fparareda.common.service.MarsRoversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/marsrover")
public class MarsRoverController {

    private final MarsRoversService marsRoversService;

    @Autowired
    public MarsRoverController(MarsRoversService marsRoversService) {
        this.marsRoversService = marsRoversService;
    }

    @GetMapping("/{marsRoverId}")
    public MarsRover find(@Valid @PathVariable long marsRoverId) throws EntityNotFoundException {
        return marsRoversService.find(marsRoverId);
    }
}
