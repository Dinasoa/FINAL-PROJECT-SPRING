package com.example.project.service;

import com.example.project.model.Criteria;
import com.example.project.model.Scholarship;
import com.example.project.repository.CriteriaRepository;
import com.example.project.repository.ScholarshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CriteriaService {
    CriteriaRepository criteriaRepository ;

    public List<Criteria> getCriteriaList(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return criteriaRepository.findAll(pageable).stream().toList();
    }

    public Criteria getCriteriaById(Long id_criteria){
        return criteriaRepository.findById(id_criteria).get() ;
    }

    public Criteria addingCriteria(Criteria criteria){
        return criteriaRepository.save(criteria) ;
    }

    public String deleteCriteriaById(Long id_criteria){
        criteriaRepository.deleteById(id_criteria);
        return "Criteria has been deleted successfully" ;
    }

    public Criteria putCriteria(Long id_criteria , Criteria criteria){
        return criteriaRepository.findById(id_criteria)
                .map(criteria1 -> {
                    criteria1.setCriteriaDescription(criteria.getCriteriaDescription()) ;
                    return criteriaRepository.save(criteria1) ;
                })
                .orElseGet(() -> {
                    criteria.setIdCriteria(id_criteria);
                    return criteriaRepository.save(criteria) ;
                }) ;
    }
}
