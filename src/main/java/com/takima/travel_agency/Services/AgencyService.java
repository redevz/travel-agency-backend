package com.takima.travel_agency.Services;

import com.takima.travel_agency.Entities.Agency;
import com.takima.travel_agency.Repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyService {
    @Autowired
    private AgencyRepository _repository;

    public Agency createAgency(Agency agency) {
        if (!this._repository.findAll().isEmpty()) {
            return null;
        }
        return this._repository.save(agency);
    }

    public Agency getAgencyById(Integer id) {
        Optional<Agency> agency = this._repository.findById(id);
        return agency.orElse(null);
    }

    public Agency updateAgency(Agency agency) {
        if (agency.getId() == null) {
            return null;
        }
        return this._repository.save(agency);
    }
}
