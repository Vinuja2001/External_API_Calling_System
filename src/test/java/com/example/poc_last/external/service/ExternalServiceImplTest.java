package com.example.poc_last.external.service;

import com.example.poc_last.domain.entities.dto.University;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class ExternalServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ExternalServiceImpl externalService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private University[] createTestUniversities() {
        List<University> universities = new ArrayList<>();
        universities.add(new University("Australian Correspondence Schools", Collections.singletonList("http://www.acs.edu.au/")));
        return universities.toArray(new University[0]);
    }

    @Test
    public void testGetFromApi_Success() {
        String country = "Australia";

        University[] universities = createTestUniversities();

        when(restTemplate.getForObject(anyString(), eq(University[].class))).thenReturn(universities);
        List<University> universityList = externalService.getFromApi(country);

        assertThat(universityList).isNotNull();
        assertThat(universityList.get(0).getName()).isEqualTo("Australian Correspondence Schools");
        assertThat(universityList.get(0).getWebPage().get(0)).isEqualTo("http://www.acs.edu.au/");
    }

    @Test
    public void testGetFromApi_Null() {

        when(restTemplate.getForObject(any(String.class), any(Class.class))).thenReturn(null);

        List<University> result = externalService.getFromApi("Country");

        assertEquals(0, result.size());
    }
}