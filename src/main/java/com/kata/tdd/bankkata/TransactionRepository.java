package com.kata.tdd.bankkata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * For the sake of the exercise, we'll stick with a memory repository
 * A real implementation would persist and retreive information from a
 * DB. This class would be an interface instead and we could have an
 * OracleTransactionRepository implementing this interface and doing real
 * persistent action
 */
public class TransactionRepository {
    private Clock clock;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        final Transaction deposit = new Transaction(clock.todayAsString(), amount);
        transactions.add(deposit);
    }

    public void addwithdrawal(int amount) {
        final Transaction withdrawal = new Transaction(clock.todayAsString(), -amount);
        transactions.add(withdrawal);
    }

    public List<Transaction> allTransactions() {
        //make sure what is returned can not be changed by
        //returning a unmodifiable copy list of transactions
        return Collections.unmodifiableList(transactions);
    }
}
