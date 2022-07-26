package com.novencia.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.novencia.main.exception.BankingFunctionalException;
import com.novencia.main.model.Account;
import com.novencia.main.model.Customer;
import com.novencia.main.service.AccountService;
import com.novencia.main.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;

public class AccountServiceTest {

  @Test
  void should_Throw_Exception_When_Deposit_Negative_Amount() {
    //Given
    Account account = new Account("1", 10, new Customer());
    AccountService accountService = new AccountServiceImpl();
    //Then
    assertThrows(BankingFunctionalException.class,
        () -> accountService.depositAmount(account, -1.0));
  }

  @Test
  void should_Throw_Exception_When_Deposit_Null_Amount() {
    //Given
    Account account = new Account("1", 10, new Customer());
    AccountService accountService = new AccountServiceImpl();
    //Then
    assertThrows(BankingFunctionalException.class,
        () -> accountService.depositAmount(account, null));
  }

  @Test
  void should_AddAmount_When_Deposit_Positive_Amount() {
    //Given
    Account account = new Account("1", 10, new Customer());
    AccountService accountService = new AccountServiceImpl();
    //When
    Account updatedAccount = accountService.depositAmount(account, 10.0);
    //Then
    assertEquals(20.0, updatedAccount.getBalance());
  }

  @Test
  void should_Throw_Exception_When_balance_less_than_Amount_withdrawn() {
    //Given
    Account account = new Account("1", 10, new Customer());
    AccountService accountService = new AccountServiceImpl();
    //Then
    assertThrows(BankingFunctionalException.class,
        () -> accountService.withdrawalAmount(account, 50.0));
  }

  @Test
  void should_withdrawalAmount_When_withdrawal_Positive_Amount() {
    //Given
    Account account = new Account("1", 30, new Customer());
    AccountService accountService = new AccountServiceImpl();
    //When
    Account updatedAccount = accountService.withdrawalAmount(account, 10.0);
    //Then
    assertEquals(20.0, updatedAccount.getBalance());
  }
}
