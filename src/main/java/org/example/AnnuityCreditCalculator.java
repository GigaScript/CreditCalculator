package org.example;

public class AnnuityCreditCalculator {

    public double monthlyPayment(int creditAmount, int numberOfMonths, double percentageYearRate) {
        double annuityRatio = annuityRatioCalc(numberOfMonths, percentageYearRate);
        return creditAmount * annuityRatio;
    }


    public double totalAmount(int creditAmount, int numberOfMonths, double percentageYearRate) {
        return numberOfMonths * monthlyPayment(
                creditAmount, numberOfMonths, percentageYearRate
        );
    }

    public double overpayment(int creditAmount, int numberOfMonths, double percentageYearRate) {
        return monthlyPayment(creditAmount, numberOfMonths, percentageYearRate)
                * numberOfMonths
                - creditAmount;
    }

    private double annuityRatioCalc(int numberOfMonths, double percentageYearRate) {
        double percentageMonthRate = percentageYearRate / 12 / 100;
        return (percentageMonthRate
                * Math.pow((1 + percentageMonthRate), numberOfMonths)
                / (Math.pow((1 + percentageMonthRate), numberOfMonths) - 1)
        );
    }
}
