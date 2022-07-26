package com.novencia.main.service.impl;

import static com.novencia.main.enums.TransactionType.CREDIT;
import static com.novencia.main.enums.TransactionType.DEBIT;

import com.novencia.main.model.Account;
import com.novencia.main.model.Transaction;
import com.novencia.main.service.TransactionService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {

  @Override
  public Transaction depositTransaction(Account account, Double amount) {
    return new Transaction(amount, DEBIT.getValue(), account, account.getBalance());
  }

  @Override
  public Transaction withdrawalTransaction(Account account, Double amount) {
    return new Transaction(amount, CREDIT.getValue(), account, account.getBalance());
  }

  @Override
  public List<Transaction> findTransactionByAccountId(String accountId,
      List<Transaction> transactions) {
    return transactions.stream()
        .filter(transaction -> Objects.equals(accountId, transaction.getAccount().getId()))
        .collect(Collectors.toList());
  }
}
