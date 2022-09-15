package com.example.project.controller;

import com.example.project.mapper.CriteriaMapper;
import com.example.project.mapper.ScholasrhipMapper;
import com.example.project.rest.Criteria;
import com.example.project.rest.Scholarship;
import com.example.project.service.ScholarshipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")

public class ScholarshipController {
    private ScholarshipService scholarshipService ;
    private ScholasrhipMapper scholasrhipMapper;

    private CriteriaMapper criteriaMapper;
    @GetMapping("/scholarships")
    public List<com.example.project.model.Scholarship> getScholarship(@RequestParam(name = "pageNumber") int page,
                                                                      @RequestParam(name = "pageSize") int pageSize){
        return scholarshipService.getScholarship(page, pageSize);
    }


    @Transactional
    @PostMapping("/scholarships")
    public com.example.project.model.Scholarship createNewScholarship(@RequestBody com.example.project.rest.Scholarship scholarship){
        return scholarshipService.addingScholarship(scholasrhipMapper.toDomain(scholarship)) ;
    }

    @DeleteMapping("/scholarships/{id_scholarship}")
    public String deleteScholarshipById(@PathVariable int id_scholarship){
        return scholarshipService.deleteScholarshipById(id_scholarship) ;
    }

    @Transactional
    @PutMapping("/scholarships/{id_scholarship}")
    public com.example.project.model.Scholarship updateORcreateScholarship(@PathVariable int id_scholarship , @RequestBody Scholarship scholarship){
//        return scholasrhipMapper.toRest(scholarshipService.putScholarship(id_scholarship , scholasrhipMapper.toDomain(scholarship))) ;
        return scholarshipService.putScholarship(id_scholarship , scholasrhipMapper.toDomain(scholarship)) ;
    }

    @Transactional
    @PostMapping("/scholarships/postCriteriaInScholarship/{id_scholarship}")
    public Scholarship addingCriteriaInSCholarship(@PathVariable int id_scholarship , @RequestBody List<Criteria> criteria){
        return scholasrhipMapper.toRest(scholarshipService.addingCriteriaInScholarship(criteria.stream().map(criteriaMapper::toDomain).toList(), id_scholarship));
    }

    @DeleteMapping("/scholarship/{id_scholarship}/{id_criteria}")
    public String removeCriteriaInScholarship(@PathVariable int id_scholarship ,
                                                      @PathVariable Long id_criteria){
         scholarshipService.deleteCriteriaInScholarship(id_scholarship , id_criteria) ;
         return "deletedSuccessfull" ;

    }

    @GetMapping("/scholarships/univ")
    public List<com.example.project.rest.Scholarship> getScholarshipByUniversity(@RequestParam(name = "university_name") String name){
        return scholarshipService.getScholarshipByUniversity(name)
                .stream().map(scholasrhipMapper::toRest)
                .toList() ;
    }

    @GetMapping("/scholarships/country")
    public List<com.example.project.rest.Scholarship> getScholarshipByCountry(@RequestParam(name = "country_name") String countryName){
        return scholarshipService.getScholarshipByCountry(countryName)
                .stream().map(scholasrhipMapper::toRest)
                .toList();
    }

    @GetMapping("/scholarships/id")
    public com.example.project.rest.Scholarship getScholarshipById(@RequestParam(name = "id_scholarship") int id_scholasrhip){
        return scholasrhipMapper.toRest(scholarshipService.getScholarshipById(id_scholasrhip));
    }

    @DeleteMapping("/scholarships/multiples/{ids}")
    public String deleteMultipleScholarship(List<Integer> ids){
        return scholarshipService.multipleDelete(ids) ;
    }

}
