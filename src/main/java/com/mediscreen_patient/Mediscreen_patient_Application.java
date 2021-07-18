package com.mediscreen_patient;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEncryptableProperties
@SpringBootApplication
@EnableFeignClients("com.mediscreen_patient")
public class Mediscreen_patient_Application {

  public static void main(String[] args) {
    SpringApplication.run(Mediscreen_patient_Application.class, args);
  }
}
