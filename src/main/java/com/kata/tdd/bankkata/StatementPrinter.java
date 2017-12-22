package com.kata.tdd.bankkata;

import java.util.List;

public class StatementPrinter {
    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);
    }
}
