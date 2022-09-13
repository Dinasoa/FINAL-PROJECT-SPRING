package com.example.project.mapper;


import com.example.project.model.Scholarship;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class ScholasrhipMapper {
    private CriteriaMapper criteriaMapper;
    public Scholarship toDomain(com.example.project.rest.Scholarship rest){
       return Scholarship.builder()
               .idScholarship(rest.getId())
               .scholarshipDescription(rest.getScholarhsipDescription())
               .amount(rest.getAmount())
               .benefits(rest.getBenefits())
               .branch(rest.getBranch())
               .country(rest.getCountry())
               .dateLimit(rest.getDateLimit())
               .degree(rest.getDegree())
               .university(rest.getUniversity())
               .scholarshipTitle(rest.getScholarshipTitle())
               .minimumAverage(rest.getMinimumAverage())
               .criteria(rest.getCriteria().stream().map(criteriaMapper::toDomain).toList())
               .build();
    }

    public com.example.project.rest.Scholarship toRest(Scholarship domain){
        return com.example.project.rest.Scholarship.builder()
                .id(domain.getIdScholarship())
                .scholarhsipDescription(domain.getScholarshipDescription())
                .amount(domain.getAmount())
                .benefits(domain.getBenefits())
                .branch(domain.getBranch())
                .country(domain.getCountry())
                .dateLimit(domain.getDateLimit())
                .degree(domain.getDegree())
                .university(domain.getUniversity())
                .scholarshipTitle(domain.getScholarshipTitle())
                .minimumAverage(domain.getMinimumAverage())
                .criteria(domain.getCriteria().stream().map(criteriaMapper::toRest).toList())
                .build();
    }
}
