package com.example.project.repository;

import com.example.project.model.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
//    @Query(value = "select a from Applicant a inner join Scholarship s where s.idScholarship = a.scholasrhip.")
//    List<Applicant> getApplicantByScholasrhipId() ;
}
