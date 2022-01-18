package com.mckh.demo.guice.dep.inject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public record Staff(long staffId,
                    String name,
                    String title,
                    Currency salaryCurrency,
                    BigDecimal monthlyBaseSalary,
                    StaffRating latestRating,
                    StaffStatus status) {

    public static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    public Staff increaseSalaryByPercentage(BigDecimal percentage) {
        var newSalary = this.monthlyBaseSalary.multiply(percentage.add(ONE_HUNDRED)).divide(ONE_HUNDRED, RoundingMode.FLOOR);
        return new Staff(
                staffId,
                name,
                title,
                salaryCurrency,
                newSalary,
                latestRating,
                status);
    }
}
