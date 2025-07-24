package com.oracle.atpdb;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class TestDataScheduler {

    private final AttendanceRepository repository;
    public static int num = 1;

    public TestDataScheduler(AttendanceRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 10000) // 10초마다 실행
    public void insertAndPrintAttendances() {
        num+= 1;
        // INSERT
        Attendance a = new Attendance("GDG"+num, LocalDateTime.of(2024, 9, 13, 9, 0));
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