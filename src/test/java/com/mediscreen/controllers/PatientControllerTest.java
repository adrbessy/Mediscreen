package com.mediscreen.controllers;

import com.mediscreen.repositories.PatientRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

  // @Autowired
  // private MockMvc mockMvc;

  @MockBean
  private PatientRestController patientRestControllerMock;
  @MockBean
  private PatientRepository patientRepositoryMock;

  // private Patient patient;

  /*
   * @Test
   * 
   * @WithMockPatient(patientname = "superadri") public void testHome() throws
   * Exception { patient = new Patient(); patient.setPatientname("adrien");
   * List<Patient> patients = new ArrayList<>();
   * 
   * when(patientRepositoryMock.findAll()) .thenReturn(patients);
   * 
   * mockMvc.perform(get("/patient/list"))
   * .andExpect(status().isOk()).andExpect(view().name("patient/list")); }
   */

}
