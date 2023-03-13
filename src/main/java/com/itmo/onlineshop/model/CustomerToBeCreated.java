package com.itmo.onlineshop.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerToBeCreated {

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 3)
  @Pattern(regexp = "") // todo only latin, ciryllic letters, whitespace and underscore
  private String username;

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 3)
  @Pattern(regexp = "") // todo only latin, ciryllic letters, numbers
  private String password;

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 3)
  @Pattern(regexp = "") // todo only latin, ciryllic letters
  private String firstName;

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 3)
  @Pattern(regexp = "") // todo only latin, ciryllic letters
  private String lastName;

  @NotBlank(message = "не должно быть пустым")
  @Pattern(regexp = "") // todo
  private String city;

  @NotBlank(message = "не должно быть пустым")
  @Pattern(regexp = "") // todo
  private String street;

  @NotBlank(message = "не должно быть пустым")
  @Pattern(regexp = "") // todo
  private int houseNumber;

  @NotBlank(message = "не должно быть пустым")
  @Pattern(regexp = "") // todo
  private int zipCode;

  @Email
  @NotBlank(message = "не должно быть пустым")
  private String email;
}
