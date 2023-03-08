package com.itmo.onlineshop.model;

import com.itmo.onlineshop.db.Position;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeToBeCreated {

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 3)
  @Pattern(regexp = "") // todo only latin, ciryllic letters, whitespace and underscore
  private String name;

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 3)
  @Pattern(regexp = "") // todo only latin, ciryllic letters, numbers
  private String password;

  @Column(name = "position")
  private Position position;

  @Column(name = "phone_number")
  @Pattern(regexp = "") // todo
  private int phoneNumber;
}
