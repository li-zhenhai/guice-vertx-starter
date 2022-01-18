package com.mckh.demo.guice.dep.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;

class GuiceApplication {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(
                new SalaryIncrementByRatingModule(),
                new MockStaffDatabaseModule()
        );
        injector.getInstance(StaffSalaryUpdater.class).run();
    }

}