package com.tss.accountController;

import com.tss.service.AccountService;

import java.util.Scanner;

public class AccountController
{
    private final AccountService service = new AccountService();

    public void createAccount(Scanner scanner)
    {
        service.createAccount(scanner);
    }


    public void showAccount(Scanner scanner)
    {
        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();
        service.showAccount(accountNumber);
    }


    public void showTransactions(Scanner scanner)
    {
        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();
        service.showTransactions(accountNumber);
    }


    public void deposit(Scanner scanner)
    {
        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        service.deposit(accountNumber, amount);
    }


    public void withdraw(Scanner scanner)
    {
        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        service.withdraw(accountNumber, amount);
    }


    public void showTotalAccounts()
    {
        service.showTotalAccounts();
    }
}
