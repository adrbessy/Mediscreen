package com.mediscreen_patient.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.mediscreen_patient.model.Patient;
import com.mediscreen_patient.repositories.PatientRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest()
public class PatientServiceImplTest {

  @Autowired
  private PatientService patientService;

  @MockBean
  private PatientRepository patientRepositoryMock;

  private Patient patient;

  @Test
  public void testGetPatients() {
    patient = new Patient();
    List<Patient> patientList = new ArrayList<>();
    patientList.add(patient);

    when(patientRepositoryMock.findAll()).thenReturn(patientList);

    List<Patient> result = patientService.getPatients();
    assertThat(result).isEqualTo(patientList);
  }

  @Test
  public void testSavePatient() {
    patient = new Patient();

    when(patientRepositoryMock.save(patient)).thenReturn(patient);

    Patient result = patientService.savePatient(patient);
    assertThat(result).isEqualTo(patient);
  }

  @Test
  public void testPatientExist() {
    Integer id = 1;

    when(patientRepositoryMock.existsById(id)).thenReturn(true);

    boolean result = patientService.patientExist(id);
    assertTrue(result);
  }

  @Test
  public void testGetPatient() {
    Integer id = 1;
    patient = new Patient();

    when(patientRepositoryMock.findById(id)).thenReturn(patient);

    assertThat(patientService.getPatient(id)).isEqualTo(patient);
  }

  @Test
  public void testGetPatientByFamilyName() {
    patient = new Patient();
    patient.setFamily("family");

    when(patientRepositoryMock.countByFamily(patient.getFamily())).thenReturn(1);
    when(patientRepositoryMock.findByFamily(patient.getFamily())).thenReturn(patient);

    assertThat(patientService.getPatient(patient.getFamily())).isEqualTo(patient);
  }

  @Test
  public void testUpdatePatient() {
    Patient patient = new Patient();
    patient.setId(1);
    patient.setGiven("adrien");
    patient.setFamily("Gaiveron");
    patient.setDob("2000-06-18");
    patient.setSex("M");
    Patient patient2 = new Patient();
    patient2.setGiven("adrienne");
    patient2.setFamily("Gaiverone");
    patient2.setDob("2004-06-18");
    patient2.setSex("F");
    patient2.setAddress("5 rue de la Chappe, Paris");
    patient2.setPhone("089898989898");

    when(patientRepositoryMock.findById(patient.getId())).thenReturn(patient);

    patientService.updatePatient(patient.getId(), patient2);

    assertThat(patient.getGiven()).isEqualTo(patient2.getGiven());
  }

  @Test
  public void testDeletePatient() {
    int id = 1;
    Patient patient = new Patient();
    patient.setId(1);
    patient.setGiven("adrien");
    patient.setFamily("Gaiveron");
    patient.setDob("2000-06-18");
    patient.setSex("M");

    when(patientRepositoryMock.findById(id)).thenReturn(patient);
    doNothing().when(patientRepositoryMock).deleteById(id);

    Patient result = patientService.deletePatient(id);
    assertThat(result).isEqualTo(patient);
  }

}
