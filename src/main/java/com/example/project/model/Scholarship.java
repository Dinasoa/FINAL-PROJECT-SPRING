package com.example.project.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Builder

public class Scholarship implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idScholarship ;
    @Column(name = "scholarship_title")
    private String scholarshipTitle ;
    @Column(name = "scholarship_description")
    private String scholarshipDescription ;
    private String university  ;
    private String degree;
    private String branch ;
    private String country ;
    private int amount ;
    private String benefits ;
    private LocalDate dateLimit ;
    private double minimumAverage;
    @ManyToMany
    @JoinColumn(name = "id_criteria")
    private List<Criteria> criteria;

}
