package com.itmo.onlineshop.db.entity;

import com.itmo.onlineshop.db.Position;
import com.itmo.onlineshop.db.RoleStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private RoleStatus role;

  @Enumerated(EnumType.STRING)
  @Column(name = "position")
  private Position position;

  @Column(name = "phone_number")
  @Pattern(regexp = "") // todo
  private String phoneNumber;

  @Column(name = "enabled")
  private boolean isEnabled;
}
