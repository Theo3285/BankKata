package com.kata.tdd.bankkata;

public class Account {
    private TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {

        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.addwithdrawal(amount);
    }

    public void printStatement() {

    }
}
