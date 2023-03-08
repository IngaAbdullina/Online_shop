package com.itmo.onlineshop.db;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Address {

  @NotNull
  private String city;
  @NotNull
  private String street;
  @NotNull
  private int houseNumber;
  @NotNull
  private int zipCode;

  @Override
  public String toString() {
    return "Address [" + city + ", " + street + ", " + houseNumber + ", " + zipCode + "]";
  }
}
