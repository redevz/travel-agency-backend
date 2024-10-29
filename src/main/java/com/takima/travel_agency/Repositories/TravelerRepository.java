package com.takima.travel_agency.Repositories;

import com.takima.travel_agency.Entities.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Integer> {
    public List<Traveler> findByTravelId(Integer travelId);
    public Traveler findByEmail(String email);
}
