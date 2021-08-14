package com.mediscreen_patient.repositories;

import com.mediscreen_patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {

  Patient findById(Integer id);

  void deleteById(Integer id);

  boolean existsById(Integer id);

  boolean existsByGivenAndFamilyAndDobAllIgnoreCase(String given, String family, String dob);

  int countByFamily(String familyName);

  Patient findByFamily(String familyName);

}
