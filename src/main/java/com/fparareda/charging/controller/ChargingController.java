package com.fparareda.charging.controller;

import com.fparareda.charging.service.ChargingService;
import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/charge")
public class ChargingController {

    private final ChargingService chargingService;

    @Autowired
    public ChargingController(ChargingService chargingService) {
        this.chargingService = chargingService;
    }

    @PutMapping("/{marsRoverId}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public MarsRover chargeBateries(@Valid @PathVariable long marsRoverId) throws EntityNotFoundException {
        return chargingService.chargeBateries(marsRoverId, true);
    }

}
