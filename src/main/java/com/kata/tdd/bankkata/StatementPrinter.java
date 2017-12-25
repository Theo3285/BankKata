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

        AtomicInteger runningBalance = new AtomicInteger(0);
        LinkedList<String> lines = new LinkedList<>();
        for (Transaction transaction : transactions) {
            String line = statementLine(transaction, runningBalance);
            lines.add(line);
        }
        for (int i = lines.size() -1; i >= 0; i--) {
            console.printLine(lines.get(i));
        }
        //using lambdas:
//        transactions.stream()
//                .map(transaction -> statementLine(transaction, runningBalance))
//                .collect(Collectors.toCollection(LinkedList::new))
//                .descendingIterator()
//                .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
        return transaction.date()
                + " | "
                + decimalFormatter.format(transaction.amount())
                + " | "
                + decimalFormatter.format(runningBalance.addAndGet(transaction.amount()));
    }
}
