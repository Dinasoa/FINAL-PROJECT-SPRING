package com.example.project.mapper;


import com.example.project.model.Scholarship;
import com.example.project.service.CriteriaService;
import com.example.project.service.ScholarshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class ScholasrhipMapper {
    private CriteriaMapper criteriaMapper;
    private CriteriaService criteriaService ;
    private ScholarshipService scholarshipService ;
    public Scholarship toDomain(com.example.project.rest.Scholarship rest){
       return Scholarship.builder()
               .idScholarship(rest.getId())
               .scholarshipDescription(rest.getScholarshipDescription())
               .amount(rest.getAmount())
               .benefits(rest.getBenefits())
               .branch(rest.getBranch())
               .country(rest.getCountry())
               .dateLimit(rest.getDateLimit())
               .degree(rest.getDegree())
               .university(rest.getUniversity())
               .scholarshipTitle(rest.getScholarshipTitle())
               .minimumAverage(rest.getMinimumAverage())
               .criteria(criteriaService.findCriteriaByIds(rest.getCriteria()))
               .build();
    }

    public com.example.project.rest.Scholarship toRest(Scholarship domain){
        return com.example.project.rest.Scholarship.builder()
                .id(domain.getIdScholarship())
                .scholarshipDescription(domain.getScholarshipDescription())
                .amount(domain.getAmount())
                .benefits(domain.getBenefits())
                .branch(domain.getBranch())
                .country(domain.getCountry())
                .dateLimit(domain.getDateLimit())
                .degree(domain.getDegree())
                .university(domain.getUniversity())
                .scholarshipTitle(domain.getScholarshipTitle())
                .minimumAverage(domain.getMinimumAverage())
                .criteria(scholarshipService.idsToCriteria(domain.getCriteria()))
                .build();
    }
}
