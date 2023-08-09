package com.example.poc_last.domain.service.impl;

import com.example.poc_last.domain.entities.dto.University;
import com.example.poc_last.domain.entities.dto.UniversityResponse;
import com.example.poc_last.external.service.ExternalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class PocServiceImplTest {
    @Mock
    private ExternalServiceImpl externalService;

    @InjectMocks
    private PocServiceImpl pocService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private List<University> getUniversity() {
        List<University> universities = new ArrayList<>();
        universities.add(new University("UOK", Collections.singletonList("http://edu.uok.lk/")));
        universities.add(new University("UOM", Collections.singletonList("http://edu.uom.lk")));
        return universities;
    }

    @Test
    public void testGetUniversitiesByCountry_Success() {
        String country = "Sri Lanka";
        when(externalService.getFromApi(country)).thenReturn(getUniversity());

        UniversityResponse universityResponse = pocService.getUniversitiesByCountry(country);

        assertThat(universityResponse.getResponseCode()).isEqualTo("200");
        assertThat(universityResponse.getResponseDesc()).isEqualTo("Success");
        assertThat(universityResponse.getUniversityDetails()).isNotNull();
        assertThat(universityResponse.getUniversityDetails().getCountry()).isEqualTo(country);
        assertThat(universityResponse.getUniversityDetails().getUniversityCount()).isEqualTo(2);
        assertThat(universityResponse.getUniversityDetails().getUniversityList()).isEqualTo(getUniversity());
    }

    @Test
    public void testGetUniversitiesByCountry_Null() {
        String country = "USA";
        when(externalService.getFromApi(country)).thenReturn(null);

        UniversityResponse universityResponse = pocService.getUniversitiesByCountry(country);

        assertThat(universityResponse.getResponseCode()).isEqualTo("400");
        assertThat(universityResponse.getResponseDesc()).isEqualTo("Country is Mandatory");
        assertThat(universityResponse.getUniversityDetails()).isNull();
    }

    @Test
    public void testGetUniversityByCountry_Empty(){
        String country = "New Zealand";
        List<University> testUniversities = new ArrayList<>();
        when(externalService.getFromApi(country)).thenReturn(testUniversities);

        UniversityResponse universityResponse = pocService.getUniversitiesByCountry(country);

        assertThat(universityResponse.getResponseCode()).isEqualTo("400");
        assertThat(universityResponse.getResponseDesc()).isEqualTo("Country is Mandatory");
        assertThat(universityResponse.getUniversityDetails()).isNull();
    }
}