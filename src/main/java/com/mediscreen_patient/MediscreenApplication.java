package com.mediscreen_patient;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class MediscreenApplication {

  public static void main(String[] args) {
    SpringApplication.run(MediscreenApplication.class, args);
  }
}
