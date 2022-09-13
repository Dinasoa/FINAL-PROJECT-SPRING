package com.example.project.mapper;

import com.example.project.model.Criteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class CriteriaMapper {
    public Criteria toDomain(com.example.project.rest.Criteria rest){
        return Criteria.builder()
                .idCriteria(rest.getIdCriteria())
                .criteriaDescription(rest.getCriteriaDescription())
                .build();
    }

    public com.example.project.rest.Criteria toRest(Criteria domain){
        return com.example.project.rest.Criteria.builder()
                .idCriteria(domain.getIdCriteria())
                .criteriaDescription(domain.getCriteriaDescription())
                .build();
    }
}
