package com.example.project.controller;

import com.example.project.model.Applicant;
import com.example.project.service.ApplicantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin

public class ApplicantController {
    private ApplicantService applicantService ;

    @GetMapping("/applicants")
    public List<Applicant> getAllApplicants (@RequestParam(name = "page") int page ,
                                             @RequestParam(name = "pageSize") int pageSize) {
        return applicantService.getApplicantList(page , pageSize) ;
    }

    @PostMapping("/applicants/create")
    public Applicant createApplicant(@RequestBody Applicant applicant){
        return applicantService.createApplicant(applicant) ;
    }

    @PutMapping("/applicants/update")
    public Applicant updateApplicant(@RequestBody Applicant applicant){
        return applicantService.updateApplicant(applicant) ;
    }

    @DeleteMapping("/delete/applicants/{id}")
    public String deleteApplicantById(@PathVariable int id){
        return applicantService.deleteApplicantById(id) ;
    }

}
