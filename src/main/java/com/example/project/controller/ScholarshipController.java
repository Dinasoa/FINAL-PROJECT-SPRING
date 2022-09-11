package com.example.project.controller;

import com.example.project.model.Criteria;
import com.example.project.model.Scholarship;
import com.example.project.service.ScholarshipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin

public class ScholarshipController {
    private ScholarshipService scholarshipService ;

    @GetMapping("/scholarships")
    public List<Scholarship> getScholarship(@RequestParam(name = "pageNumber") int page,
                                            @RequestParam(name = "pageSize") int pageSize){
        return scholarshipService.getScholarship(page,pageSize);
    }


    @Transactional
    @PostMapping("/scholarships")
    public Scholarship createNewScholarship(@RequestBody Scholarship scholarship){
        return scholarshipService.addingSchoalarship(scholarship) ;
    }

    @DeleteMapping("/scholarships/{id_scholarship}")
    public String deleteScholarshipById(@PathVariable int id_scholarship){
        return scholarshipService.deleteScholarshipById(id_scholarship) ;
    }

    @Transactional
    @PutMapping("/scholarships/{id_scholarship}")
    public Scholarship updateORcreateScholarship(@PathVariable int id_scholarship ,@RequestBody Scholarship scholarship){
        return scholarshipService.putScholarship(id_scholarship , scholarship) ;
    }

    @Transactional
    @PostMapping("/scholarships/postCriteriaInSchlarship/{id_scholarship}")
    public Scholarship addingCriteriaInSCholarship(@PathVariable int id_scholarship , @RequestBody List<Criteria> criteria){
        return scholarshipService.addingCriteriaInScholarship(criteria, id_scholarship);
    }

    @DeleteMapping("/scholarship/{id_scholarship}/{id_criteria}")
    public Scholarship removeCriteriaInScholarship(@PathVariable int id_scholarship ,
                                                      @PathVariable Long id_criteria){
        return scholarshipService.deleteCriteriaInScholarship(id_scholarship , id_criteria) ;
    }

    @GetMapping("/scholarships/univ")
    public List<Scholarship> getScholarshipByUniversity(@RequestParam(name = "university_name") String name){
        return scholarshipService.getScholarshipByUniversity(name) ;
    }

    @GetMapping("/scholarships/country")
    public List<Scholarship> getScholarshipByCountry(@RequestParam(name = "country_name") String countryName){
        return scholarshipService.getScholarshipByCountry(countryName) ;
    }

    @GetMapping("/scholarships/id")
    public Scholarship getScholarshipById(@RequestParam(name = "id_scholarship") int id_scholasrhip){
        return scholarshipService.getScholarshipById(id_scholasrhip) ;
    }

//    @DeleteMapping("/scholarships/{ids}")
//    public String deleteMultipleScholarship(List<Integer> ids){
//        return scholarshipService.multipleDelete(ids) ;
//    }

}
