package com.example.project.rest;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Criteria {
    private Long idCriteria;
    private String criteriaDescription;
}
