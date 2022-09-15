package com.example.project.service;


import com.example.project.model.Applicant;
import com.example.project.model.Criteria;
import com.example.project.model.Scholarship;
import com.example.project.repository.ApplicantRepository;
import com.example.project.repository.ScholarshipRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

public class ApplicantService {
    private ApplicantRepository applicantRepository ;
    private ScholarshipRepository scholarshipRepository;
    private ScholarshipService scholarshipService;

    public List<Applicant> getApplicantList (int page , int pageSize){
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return applicantRepository.findAll(pageable).stream().toList();
    }


    public Applicant createApplicant (Applicant applicant){
        Double applicantAVG = applicant.getLastAverage()  ;
        List<Scholarship> scholarships = applicant.getScholarship() ;
        Applicant app = applicant;
        for (Scholarship scholarship : scholarships) {
           if (scholarship.getMinimumAverage() <= applicantAVG) {
               app.setStatus("RETAINED");
               return applicantRepository.save(app) ;
           }
        }
        applicant.setStatus("REJECTED");
        return applicantRepository.save(applicant) ;
    }

    public Applicant updateApplicant (Applicant applicant){
        Applicant applicantToBeUpdated = applicantRepository.findById(applicant.getIdApplicant()).get() ;
        applicantToBeUpdated.setEmail(applicant.getEmail());
        applicantToBeUpdated.setFirstName(applicant.getFirstName());
        applicantToBeUpdated.setLastName(applicant.getLastName());
        applicantToBeUpdated.setBirthdate(applicant.getBirthdate());
        applicantToBeUpdated.setScholarship(applicant.getScholarship());
        applicantToBeUpdated.setLastAverage(applicant.getLastAverage());
        return applicantRepository.save(applicantToBeUpdated) ;
    }

    public String deleteApplicantById(int id){
         applicantRepository.deleteById(id);
         return "delete succcessfull";
    }

    public List<Applicant> getListOfApplicantByStatus (String status){
        return applicantRepository.getApplicantByStatus(status) ;
    }


}
