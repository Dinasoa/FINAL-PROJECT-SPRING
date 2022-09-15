package com.example.project.rest;


import com.example.project.model.Scholarship;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Applicant {
    private int idApplicant;
    private String firstName;
    private String lastName;
    private String email;
    private String degree;
    private LocalDate birthdate;
    private double lastAverage;
    private List<Integer> scholarshipIds;
    private String status ;
}
