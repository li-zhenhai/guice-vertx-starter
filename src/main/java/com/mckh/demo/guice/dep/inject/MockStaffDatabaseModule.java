package com.mckh.demo.guice.dep.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;

public class MockStaffDatabaseModule extends AbstractModule {
    @Provides
    @Singleton
    public StaffDatabase getStaffDatabase() {
        return new MockStaffDatabase(Set.of(
                new Staff(1, "Michael", "Director", Currency.getInstance("HKD"), BigDecimal.valueOf(20000000, 2), StaffRating.TOP, StaffStatus.ACTIVE),
                new Staff(2, "Peter", "CEO", Currency.getInstance("HKD"), BigDecimal.valueOf(15000000, 2), StaffRating.GREAT, StaffStatus.ACTIVE),
                new Staff(3, "Mary", "Manager", Currency.getInstance("HKD"), BigDecimal.valueOf(10000000, 2), StaffRating.GOOD, StaffStatus.ACTIVE),
                new Staff(4, "Tom", "Sales", Currency.getInstance("HKD"), BigDecimal.valueOf(8000000, 2), StaffRating.AVERAGE, StaffStatus.ACTIVE)
        ));
    }
}
