package com.mediscreen.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@SpringBootTest
public class PatientTests {

  @Test
  public void simpleEqualsUser() {
    EqualsVerifier.forClass(Patient.class).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
  }

}
