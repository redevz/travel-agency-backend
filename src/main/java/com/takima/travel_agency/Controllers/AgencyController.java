package com.takima.travel_agency.Controllers;

import com.takima.travel_agency.Entities.Agency;
import com.takima.travel_agency.Services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    @Autowired
    private AgencyService _service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAgency(@RequestBody Agency agency) {
        this._service.register(agency);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Agency myAgency() {
        return this._service.getMyAgency().orElse(null);
    }
}
