package ru.job4j.oop;

public class Transp {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] mass = new Vehicle[3];

        mass[0] = plane;
        mass[1] = bus;
        mass[2] = train;

        for (Vehicle v : mass) {
            v.move();
            System.out.println(v.getWheels() + " колес");
        }
    }
}