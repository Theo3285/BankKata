# Objectives 

Learn and practice the double loop of TDD
Test application from outside, identifying side effects

# Problem description - Bank Kata

Create a simple bank application with the following features:

* Deposit into account
* Withdraw from account
* Print a bank statement to the console

# Acceptance Criteria

Statement should have transaction in the following format

| DATE | AMOUNT | BALANCE |
| :--: | :--: | :--: |
| 12/12/2017 | 500.00  | 1400.00 |
| 10/12/2017 | -100.00 | 900.00 |
| 01/12/2017 | 1000.00 | 1000.00 |

# Starting point and constraints

1. Start with a class with the following structure

    public class Account {
        
        public void deposit(int amount);
        
        public void withdraw(int amount);
        
        public void printStatement();
        
    }

2. you are not allowed to add any other public method to this class

3. Use String and Integers for date and amounts (keep it simple)

4. Don't worry about spacing in the statement printed on the console

Credit: Sandro Mancuso @codurance

# Lesson learned

Start by implementing feature acceptance criteria.

Mock external world dependencies (database, console, etc) but 
use real internal implementation to test the SUT.

Always throw an exception to know what to do next after unit test 
pass and are well refactored.

Remove the exception to make the acceptance test fail for the right reason.
Once failing for the right reason, move to the inner loop of TDD

Imagine side effect in the feet of the user. What is he doing?
Think of different usage to imagine direction and design.

When getting deeper in the TDD cycle, question responsibility

For the sake of simplicity, use in memory DB and delay details.

It is extremely important to not test something that you can not control
such as the system date. Your test will fail each time their is a change in
the system you can not control. You need to control the randomness with 
something you can Mock

Always Assert first, then execute what to assert and finally initialise 
what to execute and assert.
