package com.novencia.main.model;

import java.time.LocalDateTime;

public class Account {

  private String id;
  private double balance = 0;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;
  private Customer customer;

  public Account() {
  }

  public Account(String id, Customer customer) {
    this.id = id;
    this.customer = customer;
  }

  public Account(String id, double balance, Customer customer) {
    this.id = id;
    this.createdDate = LocalDateTime.now();
    this.customer = customer;
    this.balance = balance;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDateTime getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(LocalDateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
