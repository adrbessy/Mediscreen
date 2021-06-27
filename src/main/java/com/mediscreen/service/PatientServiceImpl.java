package com.mediscreen.service;

import com.mediscreen.model.Patient;
import com.mediscreen.repositories.PatientRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

  private static final Logger logger = LogManager.getLogger(PatientServiceImpl.class);

  @Autowired
  private PatientRepository patientRepository;

  /**
   * Get all patients
   * 
   * @return all patients
   */
  @Override
  public List<Patient> getPatients() {
    logger.debug("in the method getPatients in the class PatientServiceImpl");
    List<Patient> patientList = new ArrayList<>();
    try {
      patientList = patientRepository.findAll();
    } catch (Exception exception) {
      logger.error("Error in the method getPatients :" + exception.getMessage());
    }
    return patientList;
  }

  /**
   * Save a patient
   * 
   * @param patient A patient to save
   * @return the saved patient
   */
  @Override
  public Patient savePatient(Patient patient) {
    logger.debug("in the method savePatient in the class PatientServiceImpl");
    Patient savedPatient = null;
    try {
      savedPatient = patientRepository.save(patient);
    } catch (Exception exception) {
      logger.error("Error when we try to save a patient :" + exception.getMessage());
    }
    return savedPatient;
  }

  /**
   * Check if the given patient id exists.
   * 
   * @param id The patient id
   * @return true if the id exists, otherwise returns false
   */
  @Override
  public boolean patientExist(Integer id) {
    logger.debug("in the method patientExist in the class PatientServiceImpl");
    boolean patientExist = false;
    try {
      patientExist = patientRepository.existsById(id);
    } catch (Exception exception) {
      logger.error("Error in the method patientExist :" + exception.getMessage());
    }
    return patientExist;
  }

  /**
   * Delete a patient
   * 
   * @param id An id
   * @return the deleted patient
   */
  @Transactional
  @Override
  public Patient deletePatient(Integer id) {
    logger.debug("in the method deletePatient in the class PatientServiceImpl");
    Patient patient = null;
    try {
      patient = patientRepository.findById(id);
      patientRepository.deleteById(id);
    } catch (Exception exception) {
      logger.error("Error in the method deletePatient :" + exception.getMessage());
    }
    return patient;
  }

  /**
   * Get a patient from an id
   * 
   * @param id The id of the patient table
   * @return The patientname
   */
  @Override
  public Patient getPatient(Integer id) {
    logger.debug("in the method getPatient in the class PatientServiceImpl");
    Patient patient = null;
    try {
      patient = patientRepository.findById(id);
    } catch (Exception exception) {
      logger.error("Error in the method getPatient :" + exception.getMessage());
    }
    return patient;
  }

}
