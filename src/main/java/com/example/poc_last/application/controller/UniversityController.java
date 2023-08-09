package com.example.poc_last.application.controller;

import com.example.poc_last.domain.entities.dto.UniversityResponse;
import com.example.poc_last.domain.service.PocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poc")
public class UniversityController {
    private final PocService pocService;

    @Autowired
    public UniversityController(PocService pocService) {
        this.pocService = pocService;
    }

    @GetMapping("/show")
    public ResponseEntity<UniversityResponse> getUniversities(@RequestParam(required = false) String country) {
        UniversityResponse universityResponse = pocService.getUniversitiesByCountry(country);
        if (universityResponse != null) {
            if ("200".equals(universityResponse.getResponseCode()))
                return ResponseEntity.ok(universityResponse);
            else return ResponseEntity.badRequest().body(universityResponse);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
