package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Едет");
    }

    @Override
    public int getWheels() {
        return 6;
    }
}
