package com.kata.tdd.bankkata;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StatementPrinter {

    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    private DecimalFormat decimalFormatter = new DecimalFormat("#.00",
            new DecimalFormatSymbols(Locale.US));

    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);

        LinkedList<String> lines = mapStatementLines(transactions);

        printStatementLines(lines);
    }

    private LinkedList<String> mapStatementLines(List<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        LinkedList<String> lines = new LinkedList<>();
        for (Transaction transaction : transactions) {
            String line = statementLine(transaction, runningBalance);
            lines.add(line);
        }
        return lines;
    }

    private void printStatementLines(LinkedList<String> lines) {
        final int size = lines.size();
        for (int i = size -1; i >= 0; i--) {
            console.printLine(lines.get(i));
        }
    }

    private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
        return transaction.date()
                + " | "
                + decimalFormatter.format(transaction.amount())
                + " | "
                + decimalFormatter.format(runningBalance.addAndGet(transaction.amount()));
    }
}
