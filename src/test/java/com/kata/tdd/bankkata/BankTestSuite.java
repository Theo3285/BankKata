package com.kata.tdd.bankkata;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountShould.class,
        TransactionRepositoryShould.class,
        ClockShould.class,
        StatementPrinterShould.class
})
public class BankTestSuite {
}
