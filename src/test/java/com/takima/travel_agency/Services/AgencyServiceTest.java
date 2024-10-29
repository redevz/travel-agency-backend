package com.takima.travel_agency.Services;

import com.takima.travel_agency.Entities.Agency;
import com.takima.travel_agency.Repositories.AgencyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgencyServiceTest {
    @Mock
    private AgencyRepository _repository;

    @InjectMocks
    private AgencyService _service;

    @Test
    public void AgencyService_CreateAgency_ReturnsAgency() {
        Agency agency = new Agency();
        agency.setCompanyName("Mondial Tours");
        when(_repository.save(Mockito.any(Agency.class))).thenReturn(agency);
        Agency saved = _service.createAgency(agency);
        Assertions.assertThat(saved).isNotNull();
    }

    @Test
    public void AgencyService_CreateTwice_SecondNotCreated() {
        Agency agency = new Agency();
        agency.setCompanyName("Mondial Tours");

        List<Agency> agencies = new ArrayList<>();
        agencies.add(agency);
        when(_repository.findAll()).thenReturn(agencies);

        Agency saved = _service.createAgency(agency);
        Assertions.assertThat(saved).isNull();
    }
}