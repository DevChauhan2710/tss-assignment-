package com.tss.entity;

import com.tss.enumm.AccountType;
import com.tss.enumm.TransactionType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Account
{
    private final int accountId = ThreadLocalRandom.current().nextInt(1000, 10000);
    private final long accountNumber = ThreadLocalRandom.current().nextLong(100000000L, 1000000000L);
    private String name;
    private double balance;
    private AccountType accountType;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String name, double balance, AccountType accountType)
    {
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getAccountId() {
        return accountId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public List<Transaction> getTransactions()
    {
        return new ArrayList<>(transactions);
    }


    public void deposit(double amount)
    {
        balance += amount;
        transactions.add(new Transaction(TransactionType.CREDIT, amount));
    }

    public void withdraw(double amount)
    {
        balance -= amount;
        transactions.add(new Transaction(TransactionType.DEBIT, amount));
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", transactions=" + transactions +
                '}';
    }
}