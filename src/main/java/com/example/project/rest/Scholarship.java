package com.example.project.rest;


import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Scholarship {
    private int id;
    private String scholarhsipDescription;
    private String scholarshipTitle;
    private String university;
    private String degree;
    private String branch;
    private String country;
    private int amount ;
    private String benefits;
    private Instant dateLimit;
    private double minimumAverage;
    private List<Criteria> criteria;
}
