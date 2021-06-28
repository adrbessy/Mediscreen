package com.mediscreen.controllers;

import com.mediscreen.exceptions.NonexistentException;
import com.mediscreen.model.Patient;
import com.mediscreen.service.PatientService;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientRestController {

  private static final Logger logger = LogManager.getLogger(PatientRestController.class);

  @Autowired
  private PatientService patientService;


  /**
   * Read - Get all patients
   * 
   * @return - An Iterable object of patients full filled
   */
  @GetMapping("/patients")
  public List<Patient> getPatients() {
    List<Patient> patientList = new ArrayList<>();
    try {
      logger.info("Get request with the endpoint 'patients'");
      patientList = patientService.getPatients();
      logger.info(
          "response following the GET on the endpoint 'patients'.");
    } catch (Exception exception) {
      logger.error("Error in the PatientRestController in the method getPatients :"
          + exception.getMessage());
    }
    return patientList;
  }


  /**
   * Add a new patient
   * 
   * @param patient An object patient
   * @return The patient object saved
   */
  @PostMapping("/patient")
  public Patient createPatient(@RequestBody Patient patient) {
    Patient newPatient = null;
    try {
      logger.info("Post request with the endpoint 'patient'");
      newPatient = patientService.savePatient(patient);
      logger.info(
          "response following the Post on the endpoint 'patient' with the given patient : {"
              + patient.toString() + "}");
    } catch (Exception exception) {
      logger.error("Error in the PatientRestController in the method createPatient :"
          + exception.getMessage());
    }
    return newPatient;
  }


  /**
   * Update an existing patient from a given id
   * 
   * @param id      An id
   * @param patient A patient object with modifications
   * @return The updated patient object
   */
  @PutMapping("/patient/{id}")
  public Patient updatePatient(@PathVariable("id") final Integer id,
      @RequestBody Patient patient) {
    Patient patientToUpdate = null;
    boolean existingPatientId = false;
    try {
      logger.info(
          "Put request of the endpoint 'patient' with the id : {" + id + "}");
      existingPatientId = patientService.patientExist(id);
      if (existingPatientId) {
        patientToUpdate = patientService.getPatient(id);
        logger.info(
            "response following the Put on the endpoint 'patient' with the given id : {"
                + id + "}");
        if (patientToUpdate != null) {
          String patientname = patient.getName();
          if (patientname != null) {
            patientToUpdate.setName(patientname);
          }
          String fullname = patient.getName();
          if (fullname != null) {
            patientToUpdate.setName(fullname);
          }
          String genre = patient.getGenre();
          if (genre != null) {
            patientToUpdate.setGenre(genre);
          }
          patientService.savePatient(patientToUpdate);
        }
      }
    } catch (Exception exception) {
      logger.error("Error in the PatientRestController in the method updatePatient :"
          + exception.getMessage());
    }
    if (!existingPatientId) {
      logger.error("The patient with the id " + id + " doesn't exist.");
      throw new NonexistentException("The patient with the id " + id + " doesn't exist.");
    }
    return patientToUpdate;
  }

}
