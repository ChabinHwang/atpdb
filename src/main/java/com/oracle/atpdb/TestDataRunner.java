package com.oracle.atpdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TestDataRunner implements CommandLineRunner {

    private final AttendanceRepository repository;

    public TestDataRunner(AttendanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        // INSERT
        Attendance a = new Attendance("GDSC OT1234", LocalDateTime.of(2024, 9, 13, 9, 0));
        repository.save(a);
        System.out.println("Attendance saved with id = " + a.getId());

        // SELECT ALL
        List<Attendance> allAttendances = repository.findAll();
        System.out.println("===== All Attendances =====");
        for (Attendance attendance : allAttendances) {
            System.out.println("ID: " + attendance.getId() +
                    ", Title: " + attendance.getTitle() +
                    ", Time: " + attendance.getAttendanceTime());
        }
    }
}