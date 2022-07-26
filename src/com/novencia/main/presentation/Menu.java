package com.novencia.main.presentation;

import static java.lang.System.out;

import com.novencia.main.exception.BankingFunctionalException;
import com.novencia.main.model.Account;
import com.novencia.main.model.Customer;
import com.novencia.main.model.Transaction;
import com.novencia.main.service.AccountService;
import com.novencia.main.service.TransactionService;
import com.novencia.main.service.impl.AccountServiceImpl;
import com.novencia.main.service.impl.TransactionServiceImpl;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

  public static final char CheckBalance = 'A';

  public void showMenu(Customer customer, Account account, List<Transaction> transactions) {
    AccountService accountService = new AccountServiceImpl();
    TransactionService transactionService = new TransactionServiceImpl();
    char option;

    Scanner scanner = new Scanner(System.in);

    out.println("/*--- Banking App ---*/");
    out.println("====================");
    out.println("Welcome " + customer.getFirstName() + " " + customer.getLastName());
    out.println("Your ID: " + customer.getId() + "\n");
    out.println("====================");

    out.println("A. Check balance");
    out.println("B. Deposit");
    out.println("C. Withdraw");
    out.println("D. Show transaction history");
    out.println("E. Exit");

    do {

        out.println("====================");
        out.println("Enter an option:");
        option = scanner.next().toUpperCase().charAt(0);
      try {
        switch (option) {
          case 'A':
            out.println("====================");
            out.println("Balance = " + String.format("%.2f", account.getBalance()) + "$");
            break;
          case 'B':
            out.println("====================");
            out.println("Enter an amount to deposit:");
            double amountToDeposit = scanner.nextInt();
            accountService.depositAmount(account, amountToDeposit);
            transactions.add(transactionService.depositTransaction(account, amountToDeposit));
            break;
          case 'C':
            out.println("====================");
            out.println("Enter an amount to withdraw:");
            double amountToWithdraw = scanner.nextInt();
            accountService.withdrawalAmount(account, amountToWithdraw);
            transactions.add(transactionService.withdrawalTransaction(account, amountToWithdraw));
            break;
          case 'D':
            out.println("====================");
            createTransactionsTable(
                transactionService.findTransactionByAccountId(account.getId(), transactions));
            break;
          case 'E':
            out.println("====================");
            out.println("Thank you for using our services.");
            break;

          default:
            out.println("Invalid option!, Please try again.");
            break;
        }
      } catch (BankingFunctionalException  bankingFunctionalException) {
        out.println(bankingFunctionalException.getMessage());
      }catch (InputMismatchException inputMismatchException){
        out.println("the amount must be number");
      }
    } while (option != 'E');

    scanner.close();
  }

  private void createTransactionsTable(List<Transaction> transactions) {
    String leftAlignFormat = "| %-10s | %-10s | %-10s | %-10s |%n";

    out.format("+------------+---------------------+------------+------------+%n");
    out.format("| Operation  |         date        |   amount   |   balance  |%n");
    out.format("+------------+---------------------+------------+------------+%n");

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    transactions
        .forEach(transaction -> out.format(leftAlignFormat, transaction.getTransactionType(),
            transaction.getTransactionDate().format(format), transaction.getAmount(),
            transaction.getAccount().getBalance()));
    out.format("+------------+---------------------+------------+------------+%n");
  }
}
