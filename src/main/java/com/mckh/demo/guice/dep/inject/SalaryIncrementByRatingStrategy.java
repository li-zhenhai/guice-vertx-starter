package com.mckh.demo.guice.dep.inject;

import java.math.BigDecimal;

public class SalaryIncrementByRatingStrategy implements SalaryIncrementStrategy {
    @Override
    public Staff updateBaseSalary(Staff staff) {
        return switch (staff.latestRating()) {
            case TOP, GREAT -> staff.increaseSalaryByPercentage(BigDecimal.valueOf(10));
            case GOOD -> staff.increaseSalaryByPercentage(BigDecimal.valueOf(8));
            default -> staff.increaseSalaryByPercentage(BigDecimal.valueOf(3));
        };
    }
}
