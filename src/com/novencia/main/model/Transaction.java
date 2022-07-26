package com.novencia.main.model;

import java.time.LocalDateTime;
import java.util.Random;

public class Transaction {

  private String id;
  private Double amount;
  private String transactionType;
  private Account account;
  private LocalDateTime TransactionDate;

  public double getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(double currentBalance) {
    this.currentBalance = currentBalance;
  }

  private double currentBalance;

  public Transaction() {
  }

  public Transaction(Double amount, String transactionType,
      Account account, double currentBalance) {
    this.currentBalance = currentBalance;
    this.id = generateId();
    this.amount = amount;
    this.transactionType = transactionType;
    this.account = account;
    this.TransactionDate = LocalDateTime.now();
  }

  private String generateId() {
    Random random = new Random();
    return "Transaction" + random.nextInt(100000 - 1) + 1;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public LocalDateTime getTransactionDate() {
    return TransactionDate;
  }

  public void setTransactionDate(LocalDateTime transactionDate) {
    TransactionDate = transactionDate;
  }
}
