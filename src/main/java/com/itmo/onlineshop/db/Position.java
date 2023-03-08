package com.itmo.onlineshop.db;

import lombok.Getter;

public enum Position {
  DIRECTOR("Директор"), // доступен весь функционал работы с пользователями
  ADMINISTRATOR("Администратор"), // может дизейблить продавцов, менять им пароль
  SELLER("Продавец");

  @Getter
  private final String rusValue;

  Position(String rusValue) {
    this.rusValue = rusValue;
  }
}
