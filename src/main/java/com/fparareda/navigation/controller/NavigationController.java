package com.fparareda.navigation.controller;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;
import com.fparareda.common.model.Position;
import com.fparareda.navigation.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/navigation")
public class NavigationController {

    private final NavigationService navigationService;

    @Autowired
    public NavigationController(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    @PutMapping("/{marsRoverId}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public MarsRover moveMarsRover(@Valid @PathVariable long marsRoverId, @Valid @RequestBody Position position) throws EntityNotFoundException {
        return navigationService.move(marsRoverId, position);
    }
}
