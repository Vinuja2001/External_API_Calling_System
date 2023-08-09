package com.example.poc_last.domain.entities.dto;

import java.util.List;

public class UniversityDetails {
    private String country;
    private int universityCount;
    private List<University> universityList;

    public UniversityDetails() {
    }

    public UniversityDetails(String country, int universityCount, List<University> universityList) {
        this.country = country;
        this.universityCount = universityCount;
        this.universityList = universityList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getUniversityCount() {
        return universityCount;
    }

    public void setUniversityCount(int universityCount) {
        this.universityCount = universityCount;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }
}
