package com.novencia.test.service;

import static com.novencia.main.enums.TransactionType.CREDIT;
import static com.novencia.main.enums.TransactionType.DEBIT;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.novencia.main.model.Account;
import com.novencia.main.model.Customer;
import com.novencia.main.model.Transaction;
import com.novencia.main.service.TransactionService;
import com.novencia.main.service.impl.TransactionServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TransactionServiceTest {

  @Test
  void should_CreateTransaction_When_Deposit_Amount() {
    //Given
    Account account = new Account("1", 10, new Customer());
    TransactionService transactionService = new TransactionServiceImpl();
    //When
    Transaction transaction = transactionService.depositTransaction(account, 10.0);
    //Then
    assertEquals(DEBIT.getValue(), transaction.getTransactionType());
    assertEquals(10.0, transaction.getAmount());
  }

  @Test
  void should_withdrawalAmount_When_withdrawal_Positive_Amount() {
    //Given
    Account account = new Account("1", 10, new Customer());
    TransactionService transactionService = new TransactionServiceImpl();
    //When
    Transaction transaction = transactionService.withdrawalTransaction(account, 10.0);
    //Then
    assertEquals(CREDIT.getValue(), transaction.getTransactionType());
    assertEquals(10.0, transaction.getAmount());
  }

  @Test
  void should_returnListOfAccountTransaction_When_findTransactionByAccountId() {
    //Given
    Account account = new Account("1", 10, new Customer());
    TransactionService transactionService = new TransactionServiceImpl();
    List<Transaction> transactions = List.of(
        transactionService.depositTransaction(account, 10.0),
        transactionService.withdrawalTransaction(account, 10.0)
    );
    //When
    List<Transaction> accountTransactions =
        transactionService.findTransactionByAccountId(account.getId(), transactions);
    //Then
    assertEquals(2, accountTransactions.size());
  }
}
