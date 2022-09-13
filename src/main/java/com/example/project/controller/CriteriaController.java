package com.example.project.controller;

import com.example.project.mapper.CriteriaMapper;
import com.example.project.rest.Criteria;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.project.service.CriteriaService;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin

public class CriteriaController {
    private CriteriaService criteriaService ;
    private CriteriaMapper criteriaMapper;
    @GetMapping("/criterias")
    public List<com.example.project.rest.Criteria> getListCriteria(@RequestParam(name = "pageNumber") int page,
                                                                   @RequestParam(name = "pageSize") int pageSize){
        return criteriaService.getCriteriaList(page, pageSize)
                .stream()
                .map(criteriaMapper::toRest).toList();
    }

    @GetMapping("/criteria/{id_criteria}")
    public com.example.project.rest.Criteria getCriteriaById(@PathVariable Long id_criteria){
        return criteriaMapper.toRest(criteriaService.getCriteriaById(id_criteria)) ;
    }

    @Transactional
    @PostMapping("/criterias")
    public com.example.project.rest.Criteria createCriteria(@RequestBody com.example.project.rest.Criteria criteria){
        return criteriaMapper.toRest(criteriaService.addingCriteria(criteriaMapper.toDomain(criteria))) ;
    }

    @DeleteMapping("/criteria/{id_criteria}")
    public String deleteCriteria(@PathVariable Long id_criteria){
        return criteriaService.deleteCriteriaById(id_criteria) ;
    }

    @Transactional
    @PutMapping("/criteria/{id_criteria}")
    public com.example.project.rest.Criteria upateOrcreateCriteria(@PathVariable Long id_criteria , @RequestBody Criteria criteria){
        return criteriaMapper.toRest(criteriaService.putCriteria(id_criteria , criteriaMapper.toDomain(criteria)));
    }
}
