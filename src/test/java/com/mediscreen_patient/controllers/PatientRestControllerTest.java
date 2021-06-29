package com.mediscreen_patient.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen_patient.model.Patient;
import com.mediscreen_patient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PatientService patientServiceMock;


  @Test
  public void testGetPatients() throws Exception {
    mockMvc.perform(get("/patients")).andExpect(status().isOk());
  }


  @Test
  public void testCreatePatient() throws Exception {
    Patient patient = new Patient();
    patient.setFirstname("adrien");
    patient.setName("Gaiveron");
    patient.setBirthdate("05/08/1949");
    patient.setGenre("Man");

    when(patientServiceMock.savePatient(patient)).thenReturn(patient);

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/patient")
        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
        .content(new ObjectMapper().writeValueAsString(patient));
    this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
  }


  @Test
  public void testUpdatePatient() throws Exception {
    Patient patient = new Patient();
    patient.setId(1);
    patient.setFirstname("adrien");
    patient.setName("Gaiveron");
    patient.setBirthdate("05/08/1949");
    patient.setGenre("Man");

    when(patientServiceMock.patientExist(patient.getId())).thenReturn(true);
    doNothing().when(patientServiceMock).updatePatient(patient.getId(), patient);

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/patient/" + patient.getId())
        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
        .content(new ObjectMapper().writeValueAsString(patient));
    this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
  }


}
