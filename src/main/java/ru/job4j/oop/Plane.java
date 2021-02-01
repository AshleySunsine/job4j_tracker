package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Взлетает");
    }

    @Override
    public int getWheels() {
        return 12;
    }
}
