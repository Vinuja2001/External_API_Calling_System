package com.example.poc_last.domain.service;

import com.example.poc_last.domain.entities.dto.UniversityResponse;

public interface PocService {
    UniversityResponse getUniversitiesByCountry(String country);
}
