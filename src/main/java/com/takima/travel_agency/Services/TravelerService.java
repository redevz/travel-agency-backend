package com.takima.travel_agency.Services;

import com.takima.travel_agency.Entities.Travel;
import com.takima.travel_agency.Entities.Traveler;
import com.takima.travel_agency.Repositories.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelerService {
    @Autowired
    private TravelerRepository _repository;
    @Autowired
    private TravelService _travelService;

    public Traveler createTraveler(Traveler traveler) {
        if (this._repository.findByEmail(traveler.getEmail()) != null || traveler.getTravel() == null) {
            return null;
        }
        Travel travel = this._travelService.getTravel(traveler.getTravel().getId());
        if (travel == null) {
            return null;
        }
        if (travel.getRemainingPlaces() > 0) {
            Integer nbPlacesUpdated = travel.getRemainingPlaces();
            travel.setRemainingPlaces(nbPlacesUpdated - 1);
            this._travelService.updateTravel(travel);
            traveler.setTravel(travel);
            this._repository.save(traveler);
            return traveler;
        }
        return null;
    }

    public void updateTraveler(Traveler traveler) {
        this._repository.save(traveler);
    }

    public List<Traveler> getTravelers() {
        return this._repository.findAll();
    }

    public List<Traveler> getByTravelId(Integer id) {
        return this._repository.findByTravelId(id);
    }

    public Integer deleteTraveler(Integer id) {
        Optional<Traveler> traveler = this._repository.findById(id);
        if (traveler.isPresent()) {
            Travel travel = traveler.get().getTravel();
            travel.setRemainingPlaces(travel.getRemainingPlaces() + 1);
            this._travelService.updateTravel(travel);
            traveler.get().setTravel(null);
            this._repository.deleteById(id);
            return id;
        }
        return null;
    }
}
