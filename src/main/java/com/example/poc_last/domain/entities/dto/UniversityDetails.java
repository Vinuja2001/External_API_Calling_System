package com.example.poc_last.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDetails {
    private String country;
    private int universityCount;
    private List<University> universityList;

}
