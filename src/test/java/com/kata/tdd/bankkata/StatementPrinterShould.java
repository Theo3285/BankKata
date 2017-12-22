package com.kata.tdd.bankkata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

    @Mock Console console;

    private static final List<Transaction> NO_TRANSACTIONS = EMPTY_LIST;

    @Test
    public void always_print_the_header() {

        StatementPrinter staementPrinter = new StatementPrinter(console);

        staementPrinter.print(NO_TRANSACTIONS);

        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }
}