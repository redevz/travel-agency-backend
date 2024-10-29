package com.takima.travel_agency.Controllers;

import com.takima.travel_agency.Entities.Agency;
import com.takima.travel_agency.Services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    @Autowired
    private AgencyService _service;

    @PostMapping
    public ResponseEntity<String> registerAgency(@RequestBody Agency agency) {
        Agency created = this._service.createAgency(agency);
        if (created == null) {
            return new ResponseEntity<>("You cannot register agency twice in the system", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Agency registered successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Agency> getAgency(@RequestParam Integer id) {
        Agency agency = this._service.getAgencyById(id);
        if (agency == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(agency, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateAgency(@RequestBody Agency agency) {
        if (this._service.updateAgency(agency) == null) {
            return new ResponseEntity<>("Agency could not be updated", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Agency updated successfully", HttpStatus.OK);
    }
}
