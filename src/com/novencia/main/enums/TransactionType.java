package com.novencia.main.enums;

public enum TransactionType {
  DEBIT("+"),
  CREDIT("-");

  private final String value;

  TransactionType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
