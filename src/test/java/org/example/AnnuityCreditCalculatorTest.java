package org.example;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class AnnuityCreditCalculatorTest {
    private static final AnnuityCreditCalculator CREDIT_CALCULATOR = new AnnuityCreditCalculator();
    private static final int CREDIT_AMOUNT = 2_000_000;
    private static final int NUMBER_OF_MONTH = 360;
    private static final double PERCENTAGE_YEAR_RATE = 9.9;
    private static final double PERCENTAGE_MONTH_RATE = PERCENTAGE_YEAR_RATE / 12 / 100;
    private static final double ANNUITY_RATIO = (PERCENTAGE_MONTH_RATE
            * Math.pow((1 + PERCENTAGE_MONTH_RATE), NUMBER_OF_MONTH)
            / (Math.pow((1 + PERCENTAGE_MONTH_RATE), NUMBER_OF_MONTH) - 1)
    );
    private static double MONTHLY_PAYMENT = ANNUITY_RATIO * CREDIT_AMOUNT;
    private static double TOTAL_AMOUNT = MONTHLY_PAYMENT * NUMBER_OF_MONTH;
    private static double TOTAL_OVERPAYMENT = TOTAL_AMOUNT - CREDIT_AMOUNT;

    @Test
    void monthlyPayment() {
        System.out.println(String.format(Locale.getDefault(), "Сумма ауитентного платежа %,.2f в месяц %n", MONTHLY_PAYMENT));
        assertEquals(MONTHLY_PAYMENT, CREDIT_CALCULATOR.monthlyPayment(
                        CREDIT_AMOUNT, NUMBER_OF_MONTH, PERCENTAGE_MONTH_RATE
                )
        );
    }

    @Test
    void totalAmount() {
        System.out.println(String.format(Locale.getDefault(), "Долг + проценты %,.2f за весь период %n", TOTAL_AMOUNT));
        assertEquals(TOTAL_AMOUNT, CREDIT_CALCULATOR.totalAmount(
                CREDIT_AMOUNT, NUMBER_OF_MONTH, PERCENTAGE_YEAR_RATE)
        );
    }

    @Test
    void overpaymentForPeriod() {
        System.out.println(String.format(Locale.getDefault(), "Начисленные проценты %,.2f за весь период %n", TOTAL_OVERPAYMENT));
        assertEquals(TOTAL_AMOUNT, CREDIT_CALCULATOR.overpayment(
                CREDIT_AMOUNT, NUMBER_OF_MONTH, PERCENTAGE_YEAR_RATE)
        );
    }

}