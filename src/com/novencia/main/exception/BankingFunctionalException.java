package com.novencia.main.exception;

public class BankingFunctionalException extends RuntimeException {

  private int code;
  private String message;
  private String description;

  public BankingFunctionalException() {
  }

  public BankingFunctionalException(int code, String message, String description) {
    this.code = code;
    this.message = message;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "BanipFunctionalException{" +
        "code=" + code +
        ", message='" + message + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
