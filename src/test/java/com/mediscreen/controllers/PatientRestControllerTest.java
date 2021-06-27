package com.mediscreen.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.mediscreen.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PatientService patientServiceMock;

  // private Patient patient;
  // private Patient patient2;


  @Test
  public void testGetPatients() throws Exception {
    mockMvc.perform(get("/patients")).andExpect(status().isOk());
  }

  /*
   * @Test
   * 
   * @WithMockPatient(roles = "ADMIN") public void testCreatePatient() throws
   * Exception { patient = new Patient(); patient.setId(1);
   * patient.setPatientname("patientname"); patient.setPassword("aZer0%54a");
   * patient.setFullname("fullname"); patient.setRole("patient");
   * 
   * when(patientServiceMock.savePatient(patient)).thenReturn(patient);
   * 
   * MockHttpServletRequestBuilder builder =
   * MockMvcRequestBuilders.post("/patient")
   * .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.
   * APPLICATION_JSON).characterEncoding("UTF-8") .content(new
   * ObjectMapper().writeValueAsString(patient));
   * this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()
   * ); }
   */

  /*
   * @Test
   * 
   * @WithMockPatient(roles = "ADMIN") public void testDeletePatient() throws
   * Exception { Integer id = 1; patient = new Patient(); Patient patient2 = null;
   * 
   * when(patientServiceMock.patientExist(id)).thenReturn(true);
   * when(patientServiceMock.deletePatient(id)).thenReturn(patient2);
   * 
   * mockMvc .perform(MockMvcRequestBuilders.delete("/patient?id=1"))
   * .andExpect(status().isOk()); }
   */

  /*
   * @Test
   * 
   * @WithMockPatient(roles = "ADMIN") public void
   * testDeletePatientIfidDoesntExist() throws Exception { Integer id = 1; patient
   * = new Patient();
   * 
   * when(patientServiceMock.patientExist(id)).thenReturn(false);
   * 
   * mockMvc .perform(MockMvcRequestBuilders.delete("/patient?id=1"))
   * .andExpect(status().isNotFound()); }
   */

  /*
   * @Test
   * 
   * @WithMockPatient(roles = "ADMIN") public void testUpdatePatient() throws
   * Exception { Integer id = 1; patient = new Patient(); patient.setId(id);
   * patient.setPatientname("patientname"); patient.setPassword("aZer0%54aPOP");
   * patient.setFullname("fullname"); patient.setRole("USER"); patient2 = new
   * Patient(); patient2.setPatientname("patientname2");
   * 
   * when(patientServiceMock.patientExist(id)).thenReturn(true);
   * when(patientServiceMock.getPatient(id)).thenReturn(patient);
   * when(patientServiceMock.savePatient(patient)).thenReturn(patient);
   * 
   * MockHttpServletRequestBuilder builder =
   * MockMvcRequestBuilders.put("/patient/1")
   * .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.
   * APPLICATION_JSON).characterEncoding("UTF-8") .content(new
   * ObjectMapper().writeValueAsString(patient2));
   * this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()
   * ); }
   */

}
