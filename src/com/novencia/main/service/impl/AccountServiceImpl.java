package com.novencia.main.service.impl;

import static java.util.Objects.isNull;

import com.novencia.main.exception.BankingFunctionalException;
import com.novencia.main.model.Account;
import com.novencia.main.service.AccountService;
import java.time.LocalDateTime;

public class AccountServiceImpl implements AccountService {

  @Override
  public Account depositAmount(Account account, Double amount) {
    checkAmountValidity(amount);
    double newBalance = account.getBalance() + amount;
    account.setBalance(newBalance);
    account.setModifiedDate(LocalDateTime.now());
    return account;
  }

  @Override
  public Account withdrawalAmount(Account account, Double amount) {
    checkAmountValidity(amount);
    if(account.getBalance() < amount) {
      throw new BankingFunctionalException(400, "the amount must be less than your current balance",
          "your amount exceeds your current balance");
    }
    double newBalance = account.getBalance() - amount;
    account.setBalance(newBalance);
    account.setModifiedDate(LocalDateTime.now());
    return account;
  }

  private void checkAmountValidity(Double amount) {
    if (isNull(amount) || amount < 0) {
      throw new BankingFunctionalException(400, "amount must be positive",
          "Please add a positive value");
    }
  }
}
