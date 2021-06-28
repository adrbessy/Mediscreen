package com.mediscreen.service;

import com.mediscreen.model.Patient;
import java.util.List;

public interface PatientService {

  /**
   * Get all patients
   * 
   * @return all patients
   */
  List<Patient> getPatients();

  /**
   * Save a patient
   * 
   * @param patient A patient to save
   * @return the saved patient
   */
  Patient savePatient(Patient patient);

  /**
   * Check if the given patient id exists.
   * 
   * @param id The patient id
   * @return true if the id exists, otherwise returns false
   */
  boolean patientExist(Integer id);

  /**
   * Delete a patient
   * 
   * @param id An id
   * @return the deleted patient
   */
  Patient deletePatient(Integer id);

  /**
   * Get a patient from an id
   * 
   * @param id The id of the patient table
   * @return The patient
   */
  Patient getPatient(Integer id);

  /**
   * Update a patient
   * 
   * @param id      The id of the patient to update
   * @param patient A patient to update
   */
  void updatePatient(Integer id, Patient patient);

}
