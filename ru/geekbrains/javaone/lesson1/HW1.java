package ru.geekbrains.javaone.lesson1;

public class HW1 {
    public static void main(String[] args) {

        System.out.println(zadacha1(2, 8, 7, 20));

        System.out.println(zadacha2(5, 25));

        zadacha3(-8);
        zadacha3(89);

        System.out.println(zadacha4(-20));
        System.out.println(zadacha4(102));

        zadacha5("Иван!");

        zadacha6(2020);
        zadacha6(2021);


    }

    public static double zadacha1(int a, int b, int c, int d) {
        return a * (b + ((double) c / d));

    }

    public static boolean zadacha2(int a, int b) {
        return 10 <= a + b && 20 >= a + b;
    }

    public static void zadacha3(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " является положительным.");
        } else {
            System.out.println("Число " + a + " является отрицательным.");
        }
    }


    public static boolean zadacha4(int a) {
        return a < 0;
    }

    public static void zadacha5(String s) {
        System.out.println("Привет, " + s);
    }

    public static void zadacha6(int year) {
        if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
            System.out.println(year + " Год является високосным.");
        } else {
            System.out.println(year + " Год не является високосным.");
        }


    }
}
