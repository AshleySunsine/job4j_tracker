package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Задайте вопрос:");
        scan.nextLine();
        switch (new Random().nextInt(3)) {
            case 0:
                System.out.println("Yes!");
                break;
            case 1:
                System.out.println("No!");
                break;
            default:
                System.out.println("Maybe...");
                break;
        }
    }
}
