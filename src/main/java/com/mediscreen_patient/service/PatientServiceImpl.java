package com.mediscreen_patient.service;

import com.mediscreen_patient.model.Patient;
import com.mediscreen_patient.repositories.PatientRepository;
import java.util.ArrayList;
import java.util.List;
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

  /**
   * Update a patient
   * 
   * @param id      The id of the patient to update
   * @param patient A patient to update
   */
  @Override
  public void updatePatient(Integer id, Patient patient) {
    logger.debug("in the method updatePatient in the class PatientServiceImpl");
    Patient patientToUpdate = patientRepository.findById(id);
    if (patient.getFirstname() != null) {
      patientToUpdate.setFirstname(patient.getFirstname());
    }
    if (patient.getName() != null) {
      patientToUpdate.setName(patient.getName());
    }
    if (patient.getBirthdate() != null) {
      patientToUpdate.setBirthdate(patient.getBirthdate());
    }
    if (patient.getGenre() != null) {
      patientToUpdate.setGenre(patient.getGenre());
    }
    if (patient.getPostalAddress() != null) {
      patientToUpdate.setPostalAddress(patient.getPostalAddress());
    }
    if (patient.getPhoneNumber() != null) {
      patientToUpdate.setPhoneNumber(patient.getPhoneNumber());
    }
    savePatient(patientToUpdate);
  }

}
