package com.example.project.controller;

import com.example.project.model.Criteria;
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

    @GetMapping("/criterias")
    public List<Criteria> getListCriteria(@RequestParam(name = "pageNumber") int page,
                                            @RequestParam(name = "pageSize") int pageSize){
        return criteriaService.getCriteriaList(page,pageSize);
    }

    @GetMapping("/criteria/{id_criteria}")
    public Criteria getCriteriaById(@PathVariable Long id_criteria){
        return criteriaService.getCriteriaById(id_criteria) ;
    }

    @Transactional
    @PostMapping("/criteria")
    public Criteria createCriteria(@RequestBody Criteria criteria){
        return criteriaService.addingCriteria(criteria) ;
    }

    @DeleteMapping("/criteria/{id_criteria}")
    public String deleteCriteria(@PathVariable Long id_criteria){
        return criteriaService.deleteCriteriaById(id_criteria) ;
    }

    @Transactional
    @PutMapping("/criteria/{id_criteria}")
    public Criteria upateOrcreateCriteria(@PathVariable Long id_criteria , @RequestBody Criteria criteria){
        return criteriaService.putCriteria(id_criteria , criteria) ;
    }
}
