package com.example.project.repository;

import com.example.project.model.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
//    @Query("DELETE FROM scholarship_criteria s WHERE s.id_criteria = ?2 ")
//    void deleteCriteriaInScholarship() ;
}
