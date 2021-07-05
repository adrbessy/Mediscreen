package com.mediscreen_patient.controllers;

import com.mediscreen_patient.exceptions.NonexistentException;
import com.mediscreen_patient.model.Patient;
import com.mediscreen_patient.service.PatientService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientRestController {

  private static final Logger logger = LogManager.getLogger(PatientRestController.class);

  @Autowired
  private PatientService patientService;

  /**
   * Read - Get a patient
   * 
   * @param id An id
   * @return - A patient
   */
  @GetMapping("/patient")
  public Patient getPatient(@RequestParam Integer id) {
    Patient patient = null;
    logger.info("Get request with the endpoint 'patient'");
    patient = patientService.getPatient(id);
    logger.info(
        "response following the GET on the endpoint 'patient'.");
    return patient;
  }

  /**
   * Read - Get all patients
   * 
   * @return - An Iterable object of patients full filled
   */
  @GetMapping("/patients")
  public List<Patient> getPatients() {
    List<Patient> patientList = new ArrayList<>();
    logger.info("Get request with the endpoint 'patients'");
    patientList = patientService.getPatients();
    logger.info(
        "response following the GET on the endpoint 'patients'.");
    return patientList;
  }

  /**
   * Add a new patient
   * 
   * @param patient An object patient
   * @return
   * @return The patient object saved
   */
  @PostMapping("/patient")
  public void createPatient(@RequestBody Patient patient) {
    logger.info("Post request with the endpoint 'patient'");
    patientService.savePatient(patient);
    logger.info(
        "response following the Post on the endpoint 'patient' with the given patient : {"
            + patient.toString() + "}");
  }

  /**
   * Update an existing patient from a given id
   * 
   * @param id      An id
   * @param patient A patient object with modifications
   * @return The updated patient object
   */
  @PutMapping("/patient/{id}")
  public void updatePatient(@PathVariable("id") final Integer id,
      @Valid @RequestBody Patient patient) {
    boolean existingPatientId = false;
    logger.info(
        "Put request of the endpoint 'patient' with the id : {" + id + "}");
    existingPatientId = patientService.patientExist(id);
    if (existingPatientId) {
      patientService.updatePatient(id, patient);
    }
    if (!existingPatientId) {
      logger.error("The patient with the id " + id + " doesn't exist.");
      throw new NonexistentException("The patient with the id " + id + " doesn't exist.");
    }
  }

  /**
   * Delete - Delete a patient
   * 
   * @param id An id
   * @return - The deleted patient
   */
  @DeleteMapping("/patient")
  public Patient deletePatient(@RequestParam Integer id) {
    Patient patient = null;
    boolean existingPatient = false;
    logger.info("Delete request with the endpoint 'patient'");
    existingPatient = patientService.patientExist(id);
    if (existingPatient) {
      patient = patientService.deletePatient(id);
      logger.info(
          "response following the DELETE on the endpoint 'patient'.");
    }
    if (!existingPatient) {
      logger.error("The patient with the id " + id + " doesn't exist.");
      throw new NonexistentException(
          "The patient with the id " + id + " doesn't exist.");
    }
    return patient;
  }

}
