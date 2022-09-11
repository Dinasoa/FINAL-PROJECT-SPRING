package com.example.project.repository;

import com.example.project.model.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Integer> {
//    Arrays findAll(Pageable pageable, Sort and);
    @Query("SELECT s FROM Scholarship s WHERE s.university Like ?1")
    List<Scholarship> getSholarshipByUniversity(String university) ;

    @Query("SELECT s FROM Scholarship s WHERE s.country LIKE ?1")
    List<Scholarship> getScholarshipByCountry(String country);

    List<Scholarship> getScholarshipByDateLimitIsLike(Instant limitDate);

}
