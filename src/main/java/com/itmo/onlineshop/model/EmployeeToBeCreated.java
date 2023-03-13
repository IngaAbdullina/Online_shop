package com.itmo.onlineshop.model;

import com.itmo.onlineshop.db.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeToBeCreated {

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

  private Position position;

  @Pattern(regexp = "") // todo
  private int phoneNumber;
}
