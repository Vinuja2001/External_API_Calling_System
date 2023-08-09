package com.example.poc_last.application.controller;

import com.example.poc_last.domain.entities.dto.UniversityResponse;
import com.example.poc_last.domain.service.PocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UniversityControllerTest {

    private PocService pocService;
    private UniversityController universityController;

    @BeforeEach
    public void setup() {
        pocService = mock(PocService.class);
        universityController = new UniversityController(pocService);
    }

    @Test
    public void testGetUniversities_Success() {
        String country = "Australia";

        UniversityResponse universityResponse = new UniversityResponse();
        universityResponse.setResponseCode("200");
        universityResponse.setResponseDesc("Success");

        when(pocService.getUniversitiesByCountry(any())).thenReturn(universityResponse);

        ResponseEntity<UniversityResponse> responseEntity = universityController.getUniversities(country);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(universityResponse, responseEntity.getBody());
    }

    @Test
    public void testGetUniversities_Error() {
        String country = "Australia";

        UniversityResponse universityResponse = new UniversityResponse();
        universityResponse.setResponseCode("500");

        when(pocService.getUniversitiesByCountry(any())).thenReturn(universityResponse);

        ResponseEntity<UniversityResponse> responseEntity = universityController.getUniversities(country);

        verify(pocService, times(1)).getUniversitiesByCountry(country);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(universityResponse, responseEntity.getBody());
    }
}