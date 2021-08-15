package com.mediscreen_patient.controllers;

import com.mediscreen_patient.exceptions.BadRequestException;
import com.mediscreen_patient.model.Patient;
import com.mediscreen_patient.service.PatientService;
import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
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
   * Does a patient exist?
   * 
   * @param id An id
   * @return - A boolean
   */
  @CrossOrigin
  @GetMapping("/patientByFamilyName")
  public Patient getPatient(@RequestParam String familyName) {
    logger.info("Get request with the endpoint 'patient'");
    Patient patient = patientService.getPatient(familyName);
    logger.info(
        "response following the GET on the endpoint 'patient'.");
    return patient;
  }

  /**
   * Does a patient exist?
   * 
   * @param id An id
   * @return - A boolean
   */
  @CrossOrigin
  @GetMapping("/patientExists")
  public boolean doesPatientExist(@RequestParam Integer id) {
    logger.info("Get request with the endpoint 'patientExists'");
    boolean existingPatient = patientService.patientExist(id);
    logger.info(
        "response following the GET on the endpoint 'patientExists'.");
    return existingPatient;
  }

  /**
   * Read - Get a patient
   * 
   * @param id An id
   * @return - A patient
   */
  @CrossOrigin
  @GetMapping("/patient")
  public Patient getPatient(@RequestParam Integer id) {
    logger.info("Get request with the endpoint 'patient'");
    patientService.patientExist(id);
    Patient patient = patientService.getPatient(id);
    logger.info(
        "response following the GET on the endpoint 'patient'.");
    return patient;
  }

  /**
   * Read - Get all patients
   * 
   * @return - An Iterable object of patients full filled
   */
  @CrossOrigin
  @GetMapping("/patients")
  public List<Patient> getPatients() {
    logger.info("Get request with the endpoint 'patients'");
    List<Patient> patientList = patientService.getPatients();
    logger.info(
        "response following the GET on the endpoint 'patients'.");
    return patientList;
  }

  /**
   * Add a new patient
   * 
   * @param patient An object patient
   * @return true
   */
  @CrossOrigin
  @PostMapping("/patient")
  public boolean createPatient(@Valid @RequestBody Patient patient, Errors errors) {
    logger.info("Post request with the endpoint 'patient'");
    if (errors.hasFieldErrors()) {
      FieldError fieldError = errors.getFieldError();
      logger.error("Some fields of the patient object are incorrects.");
      throw new BadRequestException(fieldError.getDefaultMessage());
    }
    patientService.savePatient(patient);
    logger.info(
        "response following the Post on the endpoint 'patient' with the given patient : {"
            + patient.toString() + "}");
    return true;
  }

  /**
   * Update an existing patient from a given id
   * 
   * @param id      An id
   * @param patient A patient object with modifications
   * @return The updated patient object
   */
  @CrossOrigin
  @PutMapping("/patient/{id}")
  public boolean updatePatient(@PathVariable("id") final Integer id,
      @Valid @RequestBody Patient patient, Errors errors) {
    logger.info(
        "Put request of the endpoint 'patient' with the id : {" + id + "}");
    if (errors.hasFieldErrors()) {
      FieldError fieldError = errors.getFieldError();
      logger.error("Some fields of the patient object are incorrects.");
      throw new BadRequestException(fieldError.getDefaultMessage());
    }
    patientService.patientExist(id);
    patientService.updatePatient(id, patient);
    logger.info(
        "response following the Put on the endpoint 'patient' with the given patient : {"
            + patient.toString() + "}");
    return true;
  }

  /**
   * Delete - Delete a patient
   * 
   * @param id An id
   * @return - The deleted patient
   */
  @DeleteMapping("/patient")
  @CrossOrigin
  public Patient deletePatient(@RequestParam Integer id) {
    logger.info("Delete request with the endpoint 'patient'");
    patientService.patientExist(id);
    Patient patient = patientService.deletePatient(id);
    logger.info(
        "response following the DELETE on the endpoint 'patient'.");

    return patient;
  }

}
