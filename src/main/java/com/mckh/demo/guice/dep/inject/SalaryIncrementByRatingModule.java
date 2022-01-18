package com.mckh.demo.guice.dep.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class SalaryIncrementByRatingModule extends AbstractModule {
    @Qualifier
    @Retention(RUNTIME)
    @interface ByRating {
    }

    @Provides
    @Singleton
    @ByRating
    public SalaryIncrementStrategy getStrategy() {
        return new SalaryIncrementByRatingStrategy();
    }
}
