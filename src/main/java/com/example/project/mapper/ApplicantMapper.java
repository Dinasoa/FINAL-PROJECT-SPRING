package com.example.project.mapper;

import com.example.project.model.Applicant;
import com.example.project.repository.ScholarshipRepository;
import com.example.project.service.ScholarshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ApplicantMapper {
    private ScholasrhipMapper scholasrhipMapper;
    private ScholarshipService scholarshipService ;
    private ScholarshipRepository scholarshipRepository ;
    public Applicant toDomain(com.example.project.rest.Applicant rest){
        return Applicant.builder()
                .idApplicant(rest.getIdApplicant())
                .firstName(rest.getFirstName())
                .lastName(rest.getLastName())
                .email(rest.getEmail())
                .birthdate(rest.getBirthdate())
                .lastAverage(rest.getLastAverage())
                .status(rest.getStatus())
                .degree(rest.getDegree())
                .scholarship(scholarshipService.findScholarshipByIds(rest.getScholarshipIds()))
                .build();
    }

    public com.example.project.rest.Applicant toRest(Applicant domain){
        return com.example.project.rest.Applicant.builder()
                .idApplicant(domain.getIdApplicant())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .email(domain.getEmail())
                .birthdate(domain.getBirthdate())
                .lastAverage(domain.getLastAverage())
                .status(domain.getStatus())
                .degree(domain.getDegree())
                .scholarshipIds(scholarshipService.getScholarshipId(domain.getScholarship()))
                .build();
    }
}
