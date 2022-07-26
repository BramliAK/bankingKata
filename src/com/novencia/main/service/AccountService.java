package com.novencia.main.service;

import com.novencia.main.model.Account;

public interface AccountService {

  Account depositAmount(Account account, Double amount);

  Account withdrawalAmount(Account account, Double amount);
}
