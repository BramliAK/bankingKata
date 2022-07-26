package com.novencia.main.service;

import com.novencia.main.model.Account;
import com.novencia.main.model.Transaction;
import java.util.List;

public interface TransactionService {

  Transaction depositTransaction(Account account, Double amount);

  Transaction withdrawalTransaction(Account account, Double amount);

  List<Transaction> findTransactionByAccountId(String accountId, List<Transaction> transactions);
}
