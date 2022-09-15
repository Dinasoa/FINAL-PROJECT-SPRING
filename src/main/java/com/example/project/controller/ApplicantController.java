package com.example.project.controller;

import com.example.project.mapper.ApplicantMapper;
import com.example.project.rest.Applicant;
import com.example.project.service.ApplicantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin("*")

public class ApplicantController {
    private ApplicantService applicantService ;
    private ApplicantMapper applicantMapper;
    @GetMapping("/applicants")
    public List<com.example.project.model.Applicant> getAllApplicants (@RequestParam(name = "page") int page ,
                                                                       @RequestParam(name = "pageSize") int pageSize) {
//        return applicantService.getApplicantList(page, pageSize)
//                .stream()
//                .map(applicantMapper::toRest).toList();
        return applicantService.getApplicantList(page , pageSize) ;
    }

    @PostMapping("/applicants/create")
    public com.example.project.model.Applicant createApplicant(@RequestBody com.example.project.model.Applicant applicant){
        return applicantService.createApplicant(applicant);
    }

    @PutMapping("/applicants/update/{id_applicant}")
    public com.example.project.model.Applicant updateApplicant(@RequestBody Applicant applicant , @PathVariable int id_applicant){
        return applicantMapper.toDomain(applicantMapper.toRest(applicantService.updateApplicant(applicantMapper.toDomain(applicant)))) ;
    }

    @DeleteMapping("/delete/applicants/{id}")
    public String deleteApplicantById(@PathVariable int id){
        return applicantService.deleteApplicantById(id) ;
    }

    @GetMapping("/applicants/status/{status}")
    public List<com.example.project.model.Applicant> getApplicantByStatus(@PathVariable String status){
        return applicantService.getListOfApplicantByStatus(status) ;
    }
}
