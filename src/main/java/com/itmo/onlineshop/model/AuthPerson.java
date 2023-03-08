package com.itmo.onlineshop.model;

import com.itmo.onlineshop.db.RoleStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthPerson {

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 1)
  private String username;

  @NotBlank(message = "не должно быть пустым")
  @Size(min = 1)
  private String password;

  @NotBlank(message = "не должно быть пустым")
  @Enumerated(EnumType.STRING)
  private RoleStatus role;
}
