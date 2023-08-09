package com.example.poc_last.domain.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UniversityResponse {
    private String responseCode;
    private String responseDesc;
    private UniversityDetails universityDetails;

    public UniversityResponse() {
    }

    public UniversityResponse(String responseCode, String responseDesc, UniversityDetails universityDetails) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
        this.universityDetails = universityDetails;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public UniversityDetails getUniversityDetails() {
        return universityDetails;
    }

    public void setUniversityDetails(UniversityDetails universityDetails) {
        this.universityDetails = universityDetails;
    }
}
