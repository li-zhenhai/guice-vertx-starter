package com.mckh.demo.guice.dep.inject;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class MockStaffDatabase implements StaffDatabase {
    private final Map<Long, Staff> allStaff;

    public MockStaffDatabase(Set<Staff> staff) {
        this.allStaff = new ConcurrentHashMap<Long, Staff>();
        staff.forEach(s -> allStaff.put(s.staffId(), s));
    }

    public Stream<Staff> getAllStaff() {
        return allStaff.values().stream();
    }

    @Override
    public void updateStaff(Staff newStaff) throws NoSuchElementException {
        allStaff.put(newStaff.staffId(), newStaff);
    }
}
