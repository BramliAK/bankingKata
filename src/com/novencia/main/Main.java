package com.novencia.main;

import com.novencia.main.model.Account;
import com.novencia.main.model.Customer;
import com.novencia.main.model.Transaction;
import com.novencia.main.presentation.Menu;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Customer customer =
        new Customer("0012345", "Ahmed Khalil", "Bramli", "ahmed.khalil.bramli@gmail.com");
    Account account = new Account("0054321", customer);
    List<Transaction> transactions = new ArrayList<>();

    Menu menu = new Menu();
    menu.showMenu(customer, account, transactions);
  }
}
