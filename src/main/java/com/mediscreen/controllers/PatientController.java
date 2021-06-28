package com.mediscreen.controllers;

import com.mediscreen.model.Patient;
import com.mediscreen.repositories.PatientRepository;
import com.mediscreen.service.PatientService;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {

  private static final Logger logger = LogManager.getLogger(PatientController.class);

  @Autowired
  private PatientRepository patientRepository;
  @Autowired
  private PatientService patientService;

  @RequestMapping("/patient/list")
  public String home(Model model) {
    logger.info(
        "request of the endpoint '/patient/list'");
    model.addAttribute("patients", patientRepository.findAll());
    return "patient/list";
  }

  @GetMapping("/patient/add")
  public String addPatient(Patient patient) {
    logger.info(
        "request of the endpoint '/patient/add'");
    return "patient/add";
  }

  @PostMapping("/patient/validate")
  public String validate(@Valid Patient patient, BindingResult result, Model model) {
    logger.info(
        "request of the endpoint '/patient/validate'");
    if (!result.hasErrors()) {
      patientRepository.save(patient);
      model.addAttribute("patients", patientRepository.findAll());
      return "redirect:/patient/list";
    }
    return "patient/add";
  }

  @GetMapping("/patient/update/{id}")
  public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    logger.info(
        "GET request of the endpoint '/patient/update/{id}'");
    Patient patient = patientRepository.findById(id);
    model.addAttribute("patient", patient);
    return "patient/update";
  }

  @PostMapping("/patient/update/{id}")
  public String updatePatient(@PathVariable("id") Integer id, @Valid Patient patient,
      BindingResult result, Model model) {
    logger.info(
        "POST request of the endpoint '/patient/update/{id}'");
    if (!result.hasErrors()) {
      patientService.updatePatient(id, patient);
      model.addAttribute("patients", patientRepository.findAll());
      return "redirect:/patient/list";
    }
    return "/patient/update";
  }

  @GetMapping("/patient/delete/{id}")
  public String deletePatient(@PathVariable("id") Integer id, Model model) {
    logger.info(
        "GET request of the endpoint '/patient/delete/{id}'");
    Patient patient = patientRepository.findById(id);
    patientRepository.delete(patient);
    model.addAttribute("patients", patientRepository.findAll());
    return "redirect:/patient/list";
  }
}
