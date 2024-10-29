package com.takima.travel_agency.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.takima.travel_agency.Entities.Agency;
import com.takima.travel_agency.Services.AgencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AgencyController.class)
@AutoConfigureMockMvc(addFilters = false)
class AgencyControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    AgencyService _service;

    @Autowired
    private ObjectMapper objectMapper;

    private Agency _agency;

    @BeforeEach
    public void init() {
        this._agency = new Agency();
        this._agency.setCompanyName("Mondial Tours");
    }

    @Test
    public void AgencyController_RegisterAgency() throws Exception {
        mvc.perform(
                post("/api/agency").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(this._agency))
        );
    }
}