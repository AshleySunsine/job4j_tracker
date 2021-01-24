package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Igor");
        student.setSecondName("Pavlov");
        student.setGroup(4);
        student.setDate(LocalDate.now());
        System.out.println("Student name: " + student.getName() + " " + student.getSecondName());
        System.out.println("Group: " + student.getGroup());
        System.out.println("Date: " + student.getDate());
    }
}
