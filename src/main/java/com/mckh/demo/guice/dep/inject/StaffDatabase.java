package com.mckh.demo.guice.dep.inject;

import java.util.stream.Stream;

public interface StaffDatabase {
    Stream<Staff> getAllStaff();

    void updateStaff(Staff staff);
}
