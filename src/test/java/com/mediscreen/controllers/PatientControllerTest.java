package com.mediscreen.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.mediscreen.model.Patient;
import com.mediscreen.service.PatientService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PatientService patientServiceMock;


  @Test
  public void testHome() throws Exception {
    Patient patient = new Patient();
    patient.setFirstname("adrien");
    patient.setName("Gaiveron");
    patient.setBirthdate("05/08/1949");
    patient.setGenre("Man");
    List<Patient> patients = new ArrayList<>();
    patients.add(patient);

    when(patientServiceMock.getPatients()).thenReturn(patients);

    mockMvc.perform(get("/patient/list"))
        .andExpect(status().isOk()).andExpect(view().name("patient/list"));
  }

  @Test
  public void testShowAddPatientForm() throws Exception {
    mockMvc.perform(get("/patient/add"))
        .andExpect(status().isOk()).andExpect(view().name("patient/add"));
  }


}
