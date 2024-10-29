package com.takima.travel_agency.Controllers;

import com.takima.travel_agency.Entities.Travel;
import com.takima.travel_agency.Services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel")
public class TravelController {
    @Autowired
    private TravelService _service;

    @PostMapping
    public ResponseEntity<String> createTravel(@RequestBody Travel travel) {
        Travel created = this._service.saveTravel(travel);
        if (created == null) {
            return new ResponseEntity<>("Travel could not be created", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Travel created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Travel>> getTravels() {
        return new ResponseEntity<>(this._service.getTravels(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getTravel(@RequestParam Integer id) {
        Travel found = this._service.getTravel(id);
        if (found == null) {
            return new ResponseEntity<>("Travel not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/premiums")
    public ResponseEntity<List<Travel>> getPremiumTravels() {
        return new ResponseEntity<>(this._service.getTravelByQuality(true), HttpStatus.OK);
    }

    @GetMapping("/economics")
    public ResponseEntity<List<Travel>> getEcoTravels() {
        return new ResponseEntity<>(this._service.getTravelByQuality(false), HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Travel>> getAvailableTravels() {
        return new ResponseEntity<>(this._service.getAvailableTravels(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateTravel(@RequestBody Travel travel) {
        Travel updated = this._service.updateTravel(travel);
        if (updated == null) {
            return new ResponseEntity<>("Travel could not be updated", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTravel(@RequestParam Integer id) {
        Integer deletedId = this._service.deleteTravel(id);
        if (deletedId == null) {
            return new ResponseEntity<>("Travel could not be deleted", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
