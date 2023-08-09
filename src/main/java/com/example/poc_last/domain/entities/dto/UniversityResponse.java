package com.example.poc_last.domain.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UniversityResponse {
    private String responseCode;
    private String responseDesc;
    private UniversityDetails universityDetails;

}
