package com.example.project.repository;

import com.example.project.model.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    @Query(value = "select a from Applicant a where a.status = ?1")
    List<Applicant> getApplicantByStatus(String status) ;
}
