package com.kata.tdd.bankkata;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClockShould {

    @Test
    public void return_todays_date_in_dd_MM_yyyy_format() {
        final Clock clock = new TestableClock();
        assertThat(clock.todayAsString(), is("12/12/2017"));
    }

    private class TestableClock extends Clock {
        @Override
        protected LocalDate today() {
            return LocalDate.of(2017, 12, 12);
        }
    }
}