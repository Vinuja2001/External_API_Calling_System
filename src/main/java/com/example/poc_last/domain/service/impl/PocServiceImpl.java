package com.example.poc_last.domain.service.impl;

import com.example.poc_last.domain.entities.dto.University;
import com.example.poc_last.domain.entities.dto.UniversityDetails;
import com.example.poc_last.domain.entities.dto.UniversityResponse;
import com.example.poc_last.domain.service.PocService;
import com.example.poc_last.external.service.ExternalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PocServiceImpl implements PocService {

    private final ExternalServiceImpl externalService;

    @Autowired
    public PocServiceImpl(ExternalServiceImpl externalService) {
        this.externalService = externalService;
    }

    @Override
    public UniversityResponse getUniversitiesByCountry(String country) {
        List<University> universities = externalService.getFromApi(country);
        if (universities == null || universities.isEmpty()) {
            return new UniversityResponse("400", "Country is Mandatory", null);
        } else {
            UniversityDetails universityDetails = new UniversityDetails(country, universities.size(), universities);
            return new UniversityResponse("200", "Success", universityDetails);
        }
    }
}
