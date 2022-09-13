package com.example.project.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Entity

public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmission ;
    private float averageMin ;
    private int age;
}
