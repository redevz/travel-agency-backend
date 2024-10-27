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

    public void register(Agency agency) {
        this._repository.save(agency);
    }

    public Optional<Agency> getMyAgency() {
        if (this._repository.findAll().isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(this._repository.findAll().getFirst());
    }
}
