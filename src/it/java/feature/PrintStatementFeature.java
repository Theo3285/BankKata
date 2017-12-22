package feature;

import com.kata.tdd.bankkata.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock Console console; //Treat Console like an external system such as a database
    @Mock Clock clock;

    private Account account;

    @Before
    public void initialise() {
        //Not a Mock because Acceptance tests the system as whole
        //Only external systems
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test public void
    print_statement_containing_transactions() {

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console); //Console must be invoked in the right order
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("12/12/2017 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("10/12/2017 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/12/2017 | 1000.00 | 1000.00");
    }
}
