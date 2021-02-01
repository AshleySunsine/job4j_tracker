package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Катит по рельсам");
    }

    @Override
    public int getWheels() {
        return 60;
    }
}
