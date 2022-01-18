package com.mckh.demo.guice.dep.inject;

/**
 * A strategy to increase salary for all staff in the company, e.g. increment based on rating, title, etc.
 */
public interface SalaryIncrementStrategy {
    Staff updateBaseSalary(Staff staff);
}
