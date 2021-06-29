package com.mediscreen_patient;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class Mediscreen_patient_Application {

  public static void main(String[] args) {
    SpringApplication.run(Mediscreen_patient_Application.class, args);
  }
}
