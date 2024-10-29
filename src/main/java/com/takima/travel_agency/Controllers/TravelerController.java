package com.takima.travel_agency.Controllers;

import com.takima.travel_agency.Entities.Traveler;
import com.takima.travel_agency.Services.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traveler")
public class TravelerController {
    @Autowired
    private TravelerService _service;

    @PostMapping
    public ResponseEntity<String> addTraveler(@RequestBody Traveler traveler) {
        Traveler created = this._service.createTraveler(traveler);
        if (created == null) {
            return new ResponseEntity<>("Traveler could not be added (Duplicated or bad request)", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Traveler added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Traveler>> getAllTravelers() {
        return new ResponseEntity<>(this._service.getTravelers(), HttpStatus.OK);
    }

    @GetMapping("/travel/{id}")
    public ResponseEntity<List<Traveler>> getTravelersByTravel(@PathVariable Integer id) {
        return new ResponseEntity<>(this._service.getByTravelId(id), HttpStatus.OK);
    }

    @PutMapping
    public void updateTraveler(@RequestBody Traveler traveler) {
        this._service.updateTraveler(traveler);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTraveler(@RequestParam Integer id) {
        Integer deletedId = this._service.deleteTraveler(id);
        if (deletedId == null) {
            return new ResponseEntity<>("Traveler could not be deleted", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
