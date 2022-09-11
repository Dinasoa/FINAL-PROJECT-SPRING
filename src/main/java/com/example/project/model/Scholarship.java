package com.example.project.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

public class Scholarship implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idScholarship ;

    @Column(name = "scholarship_title")
    private String scholarshipTitle ;

    @Column(name = "scholarshipDescription")
    private String scholarshipDescription ;

    private String university  ;

    private String degree;

    private String branch ;

    private String country ;

    private int amount ;

    private String benefits ;

    private Instant dateLimit ;

    @ManyToMany
    @JoinColumn(name = "id_criteria")
    private List<Criteria> criteria;

}
