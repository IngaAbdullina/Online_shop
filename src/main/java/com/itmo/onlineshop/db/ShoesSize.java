package com.itmo.onlineshop.db;

import lombok.Getter;

public enum ShoesSize {
  THIRTY_NINE(39),
  FOURTY(40),
  FOURTY_ONE(41);

  @Getter
  private final int value;

  ShoesSize(int value) {
    this.value = value;
  }
}
