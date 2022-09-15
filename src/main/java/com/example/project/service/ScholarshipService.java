package com.example.project.service;

import com.example.project.model.Criteria;
import com.example.project.model.Scholarship;
import com.example.project.repository.CriteriaRepository;
import com.example.project.repository.ScholarshipRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ScholarshipService {

    ScholarshipRepository scholarshipRepository ;
    CriteriaRepository criteriaRepository ;

    public List<Scholarship> getScholarship(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("dateLimit").ascending());
//        List<Scholarship> scholarships = scholarshipRepository.findAll() ;
//        LocalDate now = LocalDate.now() ;
//        for (Scholarship scholarship : scholarships) {
//            if(now.isAfter(scholarship.getDateLimit())) {
//                scholarshipRepository.deleteById(scholarship.getIdScholarship());
//            }
//        }
        return scholarshipRepository.findAll(pageable).stream().toList();
    }

    public Scholarship getScholarshipById(int id_scholarship){
        return scholarshipRepository.findById((id_scholarship)).get() ;
    }

    public Scholarship addingCriteriaInScholarship (List<Criteria> criteria , int id_scholarship){
        Scholarship scholarshipID = scholarshipRepository.findById(id_scholarship).get();
        List<Criteria> listCriteria = scholarshipID.getCriteria();
        for (Criteria i : criteria) {
           if(criteriaRepository.existsById(i.getIdCriteria())){
               listCriteria.add(criteriaRepository.findById(i.getIdCriteria()).get()) ;
           }
        }
        scholarshipID.setCriteria(listCriteria);
        return scholarshipRepository.save(scholarshipID) ;
    }

    public Scholarship deleteCriteriaInScholarship(int id_scholarship , Long id_criteria){
        Scholarship scholarship = scholarshipRepository.findById(id_scholarship).get() ;
        List<Criteria> criteria = scholarship.getCriteria() ;
        Criteria criteriaa = criteriaRepository.findById(id_criteria).get();
        criteria.remove(criteriaa);

        scholarship.setCriteria(criteria);
        scholarshipRepository.save(scholarship) ;
        return scholarship  ;
    }

    public Scholarship addingScholarship(Scholarship scholarship){
        List<Criteria> criteria =  scholarship.getCriteria() ;
        for (Criteria i : criteria) {
            if(!criteriaRepository.existsById(i.getIdCriteria()))
                criteriaRepository.save(i);
        }
        return scholarshipRepository.save(scholarship) ;
    }

    public String multipleDelete(List<Integer> ids){
        ids.forEach((e) -> deleteScholarshipById(e));
        return "Books deleted successfully";
    }

    public String deleteScholarshipById(int id_scholarship){
        scholarshipRepository.deleteById(id_scholarship);
        return "Scholarship has been successfully deleted" ;
    }

    public Scholarship putScholarship(int id_scholarship , Scholarship scholarship){
        return scholarshipRepository.findById(id_scholarship)
                .map(scholarship1 -> {
                    scholarship1.setScholarshipTitle(scholarship.getScholarshipTitle());
                    scholarship1.setScholarshipDescription(scholarship.getScholarshipDescription());
                    scholarship1.setBranch(scholarship.getBranch());
                    scholarship1.setAmount(scholarship.getAmount());
                    scholarship1.setDegree(scholarship.getDegree());
                    scholarship1.setCountry(scholarship.getCountry());
                    scholarship1.setCriteria(scholarship.getCriteria());
                    scholarship1.setUniversity(scholarship.getUniversity());
                    scholarship1.setBenefits(scholarship.getBenefits());
                    scholarship1.setMinimumAverage(scholarship.getMinimumAverage());
                    return scholarshipRepository.save(scholarship1) ;
                })
                .orElseGet(() -> {
                    scholarship.setIdScholarship(id_scholarship);
                    return scholarshipRepository.save(scholarship) ;
                }) ;
    }

    public List<Scholarship> getScholarshipByUniversity(String universityName){
        return scholarshipRepository.getSholarshipByUniversity(universityName) ;
    }

    public List<Scholarship> getScholarshipByCountry(String countryName){
        return scholarshipRepository.getScholarshipByCountry(countryName) ;
    }
    public List<Integer> getScholarshipId(List<Scholarship> scholarship ){
        List<Integer> listIds = new ArrayList<>() ;
        for (Scholarship scholarship1 : scholarship) {
            if(scholarshipRepository.existsById(scholarship1.getIdScholarship()))
                listIds.add(scholarship1.getIdScholarship()) ;
        }
        return listIds ;
    }

    public List<Scholarship> findScholarshipByIds(List<Integer> ids){
        List<Scholarship> scholarships = new ArrayList<>() ;

        for (Integer i : ids) {
            Scholarship scholarshipToBeAdded = scholarshipRepository.findById(i).get() ;
            scholarships.add(scholarshipToBeAdded) ;
        }

        return scholarships;
    }

    public List<Double> findMinAverage(List<Scholarship> scholarships){
        List<Double> minAVG = new ArrayList<>() ;
        for (Scholarship scholarship : scholarships) {
            Scholarship sc = scholarshipRepository.findById(scholarship.getIdScholarship()).get() ;
            minAVG.add(sc.getMinimumAverage()) ;
        }
        return minAVG;
    }

    public List<Long> idsToCriteria (List<Criteria> criterias){
        List<Long> ids = new ArrayList<>() ;

        for (Criteria criteria : criterias) {
            ids.add(criteria.getIdCriteria()) ;
        }
        return ids ;
    }



}
