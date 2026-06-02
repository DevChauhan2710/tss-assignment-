package com.tss.entity;

import com.tss.enumm.TransactionType;

public class Transaction {

    private final TransactionType transactionType;
    private final double amount;

    public Transaction(TransactionType transactionType, double amount)
    {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public TransactionType getTransactionType()
    {
        return transactionType;
    }

    public double getAmount()
    {
        return amount;
    }

    @Override
    public String toString()
    {
        return "Transaction{" +
                "type=" + transactionType +
                ", amount=" + amount +
                '}';
    }
}