package com.tss.service;

import com.tss.entity.Account;
import com.tss.entity.Transaction;
import com.tss.enumm.AccountType;
import com.tss.exception.AccountNotFoundException;
import com.tss.exception.InsufficientBalanceException;
import com.tss.exception.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountService
{
    private final List<Account> accounts = new ArrayList<>();

    public void createAccount(Scanner scanner)
    {
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.println("1. SAVINGS");
        System.out.println("2. CURRENT");
        System.out.print("Choose Account Type: ");
        int choice = scanner.nextInt();
        AccountType accountType = (choice == 1) ? AccountType.SAVINGS : AccountType.CURRENT;

        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        Account account = new Account(name, balance, accountType);
        accounts.add(account);

        System.out.println("Account Created Successfully!");
        System.out.println("Account Number: " + account.getAccountNumber());
    }


    public Account searchAccount(long accountNumber)
    {
        for(Account account : accounts)
        {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account Not Found");
    }


    public void deposit(long accountNumber, double amount) {

        if (amount <= 0)
        {
            throw new InvalidAmountException("Amount must be greater than 0");
        }

        Account account = searchAccount(accountNumber);
        account.deposit(amount);

        System.out.println("Amount Deposit Successfully in " + account.getName() + "'s account");
    }


    public void withdraw(long accountNumber, double amount) {

        if (amount <= 0)
        {
            throw new InvalidAmountException("Amount must be greater than 0");
        }

        Account account = searchAccount(accountNumber);

        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        account.withdraw(amount);
        System.out.println("Amount Withdrawal Successfully in " + account.getName() + "'s account");
    }


    public void showAccount(long accountNumber)
    {
        Account account = searchAccount(accountNumber);

        System.out.println("\n-------------------------------------------");
        System.out.println("Account ID   : " + account.getAccountId());
        System.out.println("Name         : " + account.getName());
        System.out.println("Balance      : " + account.getBalance());
        System.out.println("Type         : " + account.getAccountType());
        System.out.println("------------------------------------------");
    }


    public void showTransactions(long accountNumber)
    {
        Account account = searchAccount(accountNumber);
        List<Transaction> transactions = account.getTransactions();

        if (transactions.isEmpty())
        {
            System.out.println("No Transactions Found");
            return;
        }

        transactions.forEach(System.out::println);
    }


    public void showTotalAccounts()
    {
        for(Account account : accounts)
        {
            System.out.println(account + " ");
        }
    }
}