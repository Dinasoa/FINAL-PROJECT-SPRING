package com.example.project.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Entity

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
    private Instant birthdate;
    @NotBlank(message = "you have to complete this case")
    private String lastAverage;
    @ManyToMany
    @JoinColumn(name = "id_scholarsip")
    private List<Scholarship> scholasrhip ;
}