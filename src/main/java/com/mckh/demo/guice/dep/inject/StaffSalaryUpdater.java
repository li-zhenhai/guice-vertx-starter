package com.mckh.demo.guice.dep.inject;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaffSalaryUpdater {
    public static Logger LOG = LoggerFactory.getLogger(GuiceApplication.class);

    private final StaffDatabase staffDb;
    private final SalaryIncrementStrategy salaryIncrementStrategy;

    @Inject
    public StaffSalaryUpdater(StaffDatabase db, @SalaryIncrementByRatingModule.ByRating SalaryIncrementStrategy strategy) {
        this.staffDb = db;
        this.salaryIncrementStrategy = strategy;
    }

    public void run() {
        LOG.info("Before update: {}", staffDb.getAllStaff().toList());
        staffDb.getAllStaff()
                .map(salaryIncrementStrategy::updateBaseSalary)
                .forEach(staffDb::updateStaff);
        LOG.info("After update: {}", staffDb.getAllStaff().toList());
    }
}
