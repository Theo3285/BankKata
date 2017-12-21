package com.kata.tdd.bankkata;

import com.kata.tdd.bankkata.Clock;
import com.kata.tdd.bankkata.Transaction;
import com.kata.tdd.bankkata.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

    public static final String TODAY = "12/12/2017";

    @Mock Clock clock;

    private TransactionRepository transactionRepository;

    @Before
    public void initialise() {
        transactionRepository = new TransactionRepository(clock);
        given(clock.todayAsString()).willReturn(TODAY);
    }

    @Test
    public void create_and_store_a_deposit_transaction() {
        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, 100)));
    }

    @Test
    public void create_and_store_withdrawal_transaction() {
        transactionRepository.addwithdrawal(100) ;

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, -100)));
    }

    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }

}
