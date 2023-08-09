package com.example.poc_last.domain.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class University {
    private String name;
    @JsonProperty("web_pages")
    private List<String> webPage;
}
