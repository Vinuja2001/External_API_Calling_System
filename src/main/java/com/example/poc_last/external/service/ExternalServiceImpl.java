package com.example.poc_last.external.service;

import com.example.poc_last.domain.entities.dto.University;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalServiceImpl {
    static final String externalUrl = "http://universities.hipolabs.com/search?country=%s";

    public List<University> getFromApi(String country) {//check to get onther way
        String apiUrl = String.format(externalUrl, country);
        RestTemplate restTemplate = new RestTemplate();
        University[] universities = restTemplate.getForObject(apiUrl, University[].class);
        if (universities != null) {
            return Arrays.asList(universities);
        }
        return Collections.emptyList();
    }
}
