package com.itmo.onlineshop.model;

import com.itmo.onlineshop.db.Address;
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
  private String name;

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 3)
  @Pattern(regexp = "") // todo only latin, ciryllic letters, numbers
  private String password;

  @NotBlank(message = "не должно быть пустым")
  private Address address;

  @Email
  @NotBlank(message = "не должно быть пустым")
  private String email;
}
