package com.takima.travel_agency.Repositories;

import com.takima.travel_agency.Entities.Travel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class TravelRepositoryTest {
    @Autowired
    private TravelRepository _travelRepository;

    @Test
    public void TravelRepository_GetPremiums() {
        Travel travel1 = new Travel();
        travel1.setDeparture("Paris");
        travel1.setArrival("Nice");
        travel1.setIsPremium(true);

        Travel travel2 = new Travel();
        travel2.setDeparture("Lille");
        travel2.setArrival("Amiens");
        travel2.setIsPremium(false);

        Travel travel3 = new Travel();
        travel3.setDeparture("Monaco");
        travel3.setArrival("Ibiza");
        travel3.setIsPremium(true);

        List<Travel> travels = new ArrayList<>();
        travels.add(travel1);
        travels.add(travel2);
        travels.add(travel3);
        this._travelRepository.saveAll(travels);

        List<Travel> savedTravels = this._travelRepository.findByIsPremium(true);
        Assertions.assertThat(savedTravels).isNotNull();
        Assertions.assertThat(savedTravels.size()).isEqualTo(2);
    }
}