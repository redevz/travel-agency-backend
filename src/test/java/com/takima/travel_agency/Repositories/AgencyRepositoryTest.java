package com.takima.travel_agency.Repositories;

import com.takima.travel_agency.Entities.Agency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AgencyRepositoryTest {
    @Autowired
    private AgencyRepository _agencyRepository;

    @Test
    public void AgencyRepository_Save_Saved() {
        // Arrange
        Agency agency = new Agency();
        agency.setCompanyName("Travel Avenue");
        agency.setAddress("1 Rue du Général de Gaulle");
        agency.setEmail("travelavenue@gmail.com");
        agency.setWebsite("www.travelavenue.com");
        agency.setPhoneNumber("+33 7 77 77 77 77");
        // Act
        Agency saved = this._agencyRepository.save(agency);
        // Assert
        Assertions.assertThat(saved.getId()).isGreaterThan(0);
    }
}