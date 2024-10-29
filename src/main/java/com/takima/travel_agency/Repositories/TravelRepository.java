package com.takima.travel_agency.Repositories;

import com.takima.travel_agency.Entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {
    public List<Travel> findByIsPremium(Boolean isPremium);
}
