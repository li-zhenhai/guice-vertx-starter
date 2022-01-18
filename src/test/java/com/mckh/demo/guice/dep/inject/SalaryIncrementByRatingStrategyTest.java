package com.mckh.demo.guice.dep.inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

class SalaryIncrementByRatingStrategyTest {
    @Test
    public void increaseSalary() {
        var updatedStaff = new SalaryIncrementByRatingStrategy().updateBaseSalary(
                new Staff(
                        1, "my name", "my title", Currency.getInstance("HKD"),
                        BigDecimal.valueOf(1001, 2),
                        StaffRating.TOP, StaffStatus.ACTIVE)
        );
        Assertions.assertEquals(11.01, updatedStaff.monthlyBaseSalary().doubleValue(),
                "Salary increased by 10% for TOP rating staff");
    }
}