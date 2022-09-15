package com.example.project.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Entity
@Builder

public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idApplicant;
    @NotBlank(message = "first name should not be blank")
    private String firstName;
    @NotBlank(message = "last name should not be blank")
    private String lastName;
    @Email
    private String email ;
    private String degree ;
    @Past
    private LocalDate birthdate;
    private double lastAverage;
    @ManyToMany
    private List<Scholarship> scholarship ;
//    @Column(columnDefinition = "varchar default PENDING")
    private String status;
}