package com.example.project.repository;

import com.example.project.model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission , InternalError> {

}
