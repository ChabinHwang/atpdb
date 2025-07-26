package com.oracle.atpdb;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ATTENDANCE")
@Getter
@Setter
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime attendanceTime;

    public Attendance() {}

    public Attendance(String title, LocalDateTime attendanceTime) {
        this.title = title;
        this.attendanceTime = attendanceTime;
    }
    public Attendance(Long id, String title, LocalDateTime attendanceTime) {
        this.id = id;
        this.title = title;
        this.attendanceTime = attendanceTime;
    }
    // getter, setter 생략
}