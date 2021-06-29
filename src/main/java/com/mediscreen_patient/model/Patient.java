package com.mediscreen_patient.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "First name is mandatory")
  private String firstname;

  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotBlank(message = "Birthdate is mandatory")
  private String birthdate;

  @NotBlank(message = "Genre is mandatory")
  private String genre;

  private String postalAddress;

  private String phoneNumber;

}
