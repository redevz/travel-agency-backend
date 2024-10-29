package com.takima.travel_agency.Services;

import com.takima.travel_agency.Entities.Agency;
import com.takima.travel_agency.Entities.Travel;
import com.takima.travel_agency.Repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TravelService {
    @Autowired
    private TravelRepository _repository;
    @Autowired
    private AgencyService _agencyService;

    public Travel saveTravel(Travel travel) {
        if (travel.getAgency() == null || travel.getScheduled().before(new Date())) {
            return null;
        }
        Agency agency = this._agencyService.getAgencyById(travel.getAgency().getId());
        if (agency == null) {
            return null;
        }
        travel.setAgency(agency);
        return this._repository.save(travel);
    }

    public Travel updateTravel(Travel travel) {
        if (travel.getId() == null || travel.getAgency() == null) {
            return null;
        }
        return this._repository.save(travel);
    }

    public List<Travel> getTravels() {
        return this._repository.findAll();
    }

    public Travel getTravel(Integer id) {
        return this._repository.findById(id).orElse(null);
    }

    public List<Travel> getTravelByQuality(Boolean isHigh) {
        return this._repository.findByIsPremium(isHigh);
    }

    public List<Travel> getAvailableTravels() {
        return this._repository.findAll().stream().filter(travel -> travel.getRemainingPlaces() > 0).toList();
    }

    public Integer deleteTravel(Integer id) {
        if (this._repository.existsById(id)) {
            this._repository.deleteById(id);
            return id;
        }
        return null;
    }
}
