package com.kata.tdd.bankkata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

    @Mock Console console;

    private static final List<Transaction> NO_TRANSACTIONS = EMPTY_LIST;

    @Test
    public void always_print_the_header() {

        StatementPrinter statementPrinter = new StatementPrinter(console);

        statementPrinter.print(NO_TRANSACTIONS);

        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void print_transactions_in_reverse_chronological_order() {

        StatementPrinter statementPrinter = new StatementPrinter(console);

        List<Transaction> transactions = transactionContaining(
                                            deposit("01/12/2017", 1000),
                                            withdrawal("10/12/2017", 100),
                                            deposit("12/12/2017", 500)
        );

        statementPrinter.print(transactions);

        InOrder inOrder = Mockito.inOrder(console); //Console must be invoked in the right order
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("12/12/2017 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("10/12/2017 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/12/2017 | 1000.00 | 1000.00");
    }

    private List<Transaction> transactionContaining(Transaction... transactions) {
        return asList(transactions);
    }

    private Transaction withdrawal(String date, int amount) {
        return new Transaction(date, -amount);
    }

    private Transaction deposit(String date, int amount) {
        return new Transaction(date, amount);
    }
}