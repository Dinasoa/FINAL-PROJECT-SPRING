package com.example.project.rest;


import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Scholarship {
    private int id;
    private String scholarshipDescription;
    private String scholarshipTitle;
    private String university;
    private String degree;
    private String branch;
    private String country;
    private int amount ;
    private String benefits;
    private LocalDate dateLimit;
    private double minimumAverage;
    private List<Long> criteria;
}
